package edu.uoc.workoutwizardroutinemanagment.mappers;


import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseWithReps;
import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import edu.uoc.workoutwizardroutinemanagment.domain.RoutineDay;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class RoutineDomainToClient {
    private RoutineDomainToClient () {}

    public static com.example.routineclient.dtos.Routine transform(Routine routine) {
        return new com.example.routineclient.dtos.Routine(routine.getId(), routine.getBlocks().stream()
                .map(RoutineDomainToClient::transform)
                .toList());
    }

    public static com.example.routineclient.dtos.RoutineDay transform(RoutineDay routine) {
        return new com.example.routineclient.dtos.RoutineDay(routine.getId(), routine.getExercises().stream()
                .map(RoutineDomainToClient::transform)
                .toList());
    }

    public static com.example.routineclient.dtos.ExerciseWithReps transform(ExerciseWithReps exerciseWithReps) {
        return new com.example.routineclient.dtos.ExerciseWithReps(
                exerciseWithReps.getId(),
                exerciseWithReps.getType(),
                exerciseWithReps.getRole(),
                exerciseWithReps.getName(),
                exerciseWithReps.getDescription(),
                exerciseWithReps.getSets(),
                exerciseWithReps.getReps()
        );
    }

    public static Routine transform(com.example.routineclient.dtos.Routine routine, UUID userId) {
        return Routine.builder()
                .id(routine.id())
                .userId(userId)
                .blocks(routine.blocks().stream()
                        .map(RoutineDomainToClient::transform)
                        .toList())
                .createdDate(Instant.now())
                .build();
    }

    public static RoutineDay transform(com.example.routineclient.dtos.RoutineDay routine) {
        return new RoutineDay(routine.id(),  routine.exercises().stream()
                .map(RoutineDomainToClient::transform)
                .toList());
    }

    public static ExerciseWithReps transform(com.example.routineclient.dtos.ExerciseWithReps exerciseWithReps) {
        return new ExerciseWithReps(
                Optional.of(exerciseWithReps.getId()).orElse(UUID.randomUUID()),
                exerciseWithReps.getType(),
                exerciseWithReps.getRole(),
                exerciseWithReps.getName(),
                exerciseWithReps.getDescription(),
                exerciseWithReps.getSets(),
                exerciseWithReps.getReps()
        );
    }
}
