package edu.uoc.workoutwizardroutinemanagment.service;

import edu.uoc.workoutwizardroutinemanagment.domain.Exercise;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseRole;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseWithReps;
import edu.uoc.workoutwizardroutinemanagment.domain.ExperienceLevel;
import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import edu.uoc.workoutwizardroutinemanagment.domain.RoutineDay;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.uoc.workoutwizardroutinemanagment.domain.ExerciseRole.COMPLEMENTARY;
import static edu.uoc.workoutwizardroutinemanagment.domain.ExerciseRole.MAIN;
import static edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType.*;
import static java.util.stream.Collectors.groupingBy;

@Service
public class RoutineService {

    private static final Map<ExerciseType, Map<ExerciseRole, List<Exercise>>> typeRoleMap =
            Stream.of(Exercise.values())
                    .collect(groupingBy(
                            Exercise::getType,
                            groupingBy(
                                    Exercise::getRole,
                                    Collectors.toUnmodifiableList()
                            )
                    ));

    private static final Map<ExerciseRole, Map<ExerciseType, List<Exercise>>> roleTypeMap =
            Stream.of(Exercise.values())
                    .collect(Collectors.groupingBy(
                            Exercise::getRole,
                            Collectors.groupingBy(
                                    Exercise::getType,
                                    Collectors.toUnmodifiableList()
                            )
                    ));


    public static Routine generateRoutine(int trainingDays, ExperienceLevel level) {
        List<RoutineDay> routineDays = new ArrayList<>();

        Map<Integer, Set<ExerciseType>> schedule = allocateMuscleGroups(trainingDays);
        for (int day = 1; day <= trainingDays; day++) {
            List<ExerciseWithReps> dayRoutine = new ArrayList<>();
            Set<ExerciseType> muscleGroups = schedule.get(day);
            for (ExerciseType group : muscleGroups) {
                dayRoutine.addAll(selectExercisesForGroup(group, level));
            }

            routineDays.add(RoutineDay.builder()
                    .exercises(dayRoutine)
                    .build());
        }

        return Routine.builder().blocks(routineDays).build();
    }

    private static Map<Integer, Set<ExerciseType>> allocateMuscleGroups(int days) {
        return switch (days) {
            case 1 -> Map.of(1, Set.of(CHEST, BACK, LEGS, CORE));
            case 2 -> Map.of(
                    1, Set.of(CHEST, SHOULDERS, TRICEPS),
                    2, Set.of(BACK, BICEPS, LEGS, CORE));
            case 3 -> Map.of(
                    1, Set.of(CHEST, TRICEPS),
                    2, Set.of(BACK, BICEPS),
                    3, Set.of(LEGS, SHOULDERS, CORE));
            case 4 -> Map.of(
                    1, Set.of(CHEST, TRICEPS),
                    2, Set.of(BACK, BICEPS),
                    3, Set.of(LEGS, CORE),
                    4, Set.of(SHOULDERS));
            case 5 -> Map.of(
                    1, Set.of(CHEST, TRICEPS),
                    2, Set.of(BACK),
                    3, Set.of(LEGS),
                    4, Set.of(SHOULDERS, CORE),
                    5, Set.of(CHEST, BICEPS));
            case 6 -> Map.of(
                    1, Set.of(CHEST),
                    2, Set.of(BACK),
                    3, Set.of(LEGS),
                    4, Set.of(SHOULDERS, TRICEPS),
                    5, Set.of(CHEST, CORE),
                    6, Set.of(BACK, BICEPS));
            case 7 -> Map.of(
                    1, Set.of(CHEST),
                    2, Set.of(BACK),
                    3, Set.of(LEGS),
                    4, Set.of(SHOULDERS),
                    5, Set.of(TRICEPS, CORE),
                    6, Set.of(CHEST, BICEPS),
                    7, Set.of(BACK, LEGS));
            default -> throw new IllegalArgumentException("Invalid number of training days");
        };
    }

    private static Collection<ExerciseWithReps> selectExercisesForGroup(ExerciseType group, ExperienceLevel level) {
        final var exercises = switch (level) {
            case BEGINNER -> selectExercisesForGroupBeginner(group);
            case INTERMEDIATE -> selectExercisesForGroupIntermediate(group);
            case ADVANCED -> selectExercisesForGroupAdvanced(group);
        };

        return exercises.stream().map(ex -> ExerciseWithReps.builder()
                .exercise(ex)
                .withExpertise(level)
                .build()
        ).collect(Collectors.toList());
    }

    private static Collection<Exercise> selectExercisesForGroupAdvanced(ExerciseType group) {
        var mainExercises = new ArrayList<>(typeRoleMap.get(group).get(MAIN));
        var complementaryExercises = new ArrayList<>(typeRoleMap.get(group).get(COMPLEMENTARY));

        return List.of(
                getRamndonExercise(mainExercises),
                getRamndonExercise(complementaryExercises),
                getRamndonExercise(complementaryExercises));
    }

    private static Collection<Exercise> selectExercisesForGroupIntermediate(ExerciseType group) {
        var mainExercises = new ArrayList<>(typeRoleMap.get(group).get(MAIN));
        var complementaryExercises = new ArrayList<>(typeRoleMap.get(group).get(COMPLEMENTARY));

        return List.of(getRamndonExercise(mainExercises), getRamndonExercise(complementaryExercises));
    }

    private static Collection<Exercise> selectExercisesForGroupBeginner(ExerciseType group) {
        var mainExercises = new ArrayList<>(typeRoleMap.get(group).get(MAIN));

        return List.of(getRamndonExercise(mainExercises));
    }

    private static Exercise getRamndonExercise(List<Exercise> exercises) {
        final var index = new Random().nextInt(exercises.size());
        final var exercise = exercises.get(new Random().nextInt(exercises.size()));
        exercises.remove(index);
        return exercise;
    }
}
