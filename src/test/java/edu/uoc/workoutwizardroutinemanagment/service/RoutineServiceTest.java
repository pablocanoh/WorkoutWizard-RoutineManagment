package edu.uoc.workoutwizardroutinemanagment.service;

import edu.uoc.workoutwizardroutinemanagment.domain.Exercise;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseRole;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType;
import edu.uoc.workoutwizardroutinemanagment.domain.ExperienceLevel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType.*;
import static org.junit.jupiter.api.Assertions.*;

public class RoutineServiceTest {

    // Frequency 1
    @Test
    void testRoutineGeneration_for_BEGGINER_with_frequency_1() {
        // given when
        var routine = RoutineService.generateRoutine(1, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, LEGS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_1() {
        // given when
        var routine = RoutineService.generateRoutine(1, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(8, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, LEGS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCED_with_frequency_1() {
        // given when
        var routine = RoutineService.generateRoutine(1, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(12, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, LEGS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);
    }

    // Frequency 2
    @Test
    void testRoutineGeneration_for_BEGGINER_with_frequency_2() {
        // given when
        var routine = RoutineService.generateRoutine(2, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, SHOULDERS, 1, 0);
        assertRolesByType(exercise, TRICEPS, 1, 0);

        exercise = routine.get(1);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);
        assertRolesByType(exercise, LEGS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_2() {
        // given when
        var routine = RoutineService.generateRoutine(2, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, SHOULDERS, 1, 1);
        assertRolesByType(exercise, TRICEPS, 1, 1);

        exercise = routine.get(1);
        assertEquals(8, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);
        assertRolesByType(exercise, LEGS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCED_with_frequency_2() {
        // given when
        var routine = RoutineService.generateRoutine(2, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(9, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, SHOULDERS, 1, 2);
        assertRolesByType(exercise, TRICEPS, 1, 2);

        exercise = routine.get(1);
        assertEquals(12, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);
        assertRolesByType(exercise, LEGS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);
    }

    // Frequency 3
    @Test
    void testRoutineGeneration_for_BEGINNER_with_frequency_3() {
        // given when
        var routine = RoutineService.generateRoutine(3, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, TRICEPS, 1, 0);

        exercise = routine.get(1);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);

        exercise = routine.get(2);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 0);
        assertRolesByType(exercise, SHOULDERS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_3() {
        // given when
        var routine = RoutineService.generateRoutine(3, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, TRICEPS, 1, 1);

        exercise = routine.get(1);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);

        exercise = routine.get(2);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 1);
        assertRolesByType(exercise, SHOULDERS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCE_with_frequency_3() {
        // given when
        var routine = RoutineService.generateRoutine(3, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, TRICEPS, 1, 2);

        exercise = routine.get(1);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);

        exercise = routine.get(2);
        assertEquals(9, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 2);
        assertRolesByType(exercise, SHOULDERS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);
    }

    // Frequency 4
    @Test
    void testRoutineGeneration_for_BEGINNER_with_frequency_4() {
        // given when
        var routine = RoutineService.generateRoutine(4, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, TRICEPS, 1, 0);

        exercise = routine.get(1);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);

        exercise = routine.get(2);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);

        exercise = routine.get(3);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_4() {
        // given when
        var routine = RoutineService.generateRoutine(4, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, TRICEPS, 1, 1);

        exercise = routine.get(1);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);

        exercise = routine.get(2);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);

        exercise = routine.get(3);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCE_with_frequency_4() {
        // given when
        var routine = RoutineService.generateRoutine(4, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, TRICEPS, 1, 2);

        exercise = routine.get(1);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);

        exercise = routine.get(2);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);

        exercise = routine.get(3);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 2);
    }

    // Frequency 5
    @Test
    void testRoutineGeneration_for_BEGINNER_with_frequency_5() {
        // given when
        var routine = RoutineService.generateRoutine(5, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, TRICEPS, 1, 0);

        exercise = routine.get(1);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);

        exercise = routine.get(2);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 0);

        exercise = routine.get(3);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);

        exercise = routine.get(4);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_5() {
        // given when
        var routine = RoutineService.generateRoutine(5, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, TRICEPS, 1, 1);

        exercise = routine.get(1);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);

        exercise = routine.get(2);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 1);

        exercise = routine.get(3);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);

        exercise = routine.get(4);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCE_with_frequency_5() {
        // given when
        var routine = RoutineService.generateRoutine(5, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, TRICEPS, 1, 2);

        exercise = routine.get(1);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);

        exercise = routine.get(2);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 2);

        exercise = routine.get(3);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);

        exercise = routine.get(4);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);
    }

    // Frequency 6
    @Test
    void testRoutineGeneration_for_BEGINNER_with_frequency_6() {
        // given when
        var routine = RoutineService.generateRoutine(6, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);

        exercise = routine.get(1);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);

        exercise = routine.get(2);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 0);

        exercise = routine.get(3);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 0);
        assertRolesByType(exercise, TRICEPS, 1, 0);

        exercise = routine.get(4);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);

        exercise = routine.get(5);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_6() {
        // given when
        var routine = RoutineService.generateRoutine(6, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);

        exercise = routine.get(1);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);

        exercise = routine.get(2);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 1);

        exercise = routine.get(3);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 1);
        assertRolesByType(exercise, TRICEPS, 1, 1);

        exercise = routine.get(4);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);

        exercise = routine.get(5);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCE_with_frequency_6() {
        // given when
        var routine = RoutineService.generateRoutine(6, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);

        exercise = routine.get(1);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);

        exercise = routine.get(2);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 2);

        exercise = routine.get(3);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 2);
        assertRolesByType(exercise, TRICEPS, 1, 2);

        exercise = routine.get(4);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);

        exercise = routine.get(5);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);
    }

    // Frequency 7
    @Test
    void testRoutineGeneration_for_BEGINNER_with_frequency_7() {
        // given when
        var routine = RoutineService.generateRoutine(7, ExperienceLevel.BEGINNER);

        // then
        var exercise = routine.get(0);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);

        exercise = routine.get(1);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);

        exercise = routine.get(2);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 0);

        exercise = routine.get(3);
        assertEquals(1, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 0);

        exercise = routine.get(4);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, TRICEPS, 1, 0);
        assertRolesByType(exercise, CORE, 1, 0);

        exercise = routine.get(5);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 0);
        assertRolesByType(exercise, BICEPS, 1, 0);

        exercise = routine.get(6);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 0);
        assertRolesByType(exercise, LEGS, 1, 0);
    }

    @Test
    void testRoutineGeneration_for_INTERMEDIATE_with_frequency_7() {
        // given when
        var routine = RoutineService.generateRoutine(7, ExperienceLevel.INTERMEDIATE);

        // then
        var exercise = routine.get(0);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);

        exercise = routine.get(1);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);

        exercise = routine.get(2);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 1);

        exercise = routine.get(3);
        assertEquals(2, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 1);

        exercise = routine.get(4);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, TRICEPS, 1, 1);
        assertRolesByType(exercise, CORE, 1, 1);

        exercise = routine.get(5);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 1);
        assertRolesByType(exercise, BICEPS, 1, 1);

        exercise = routine.get(6);
        assertEquals(4, exercise.size());
        assertRolesByType(exercise, BACK, 1, 1);
        assertRolesByType(exercise, LEGS, 1, 1);
    }

    @Test
    void testRoutineGeneration_for_ADVANCE_with_frequency_7() {
        // given when
        var routine = RoutineService.generateRoutine(7, ExperienceLevel.ADVANCED);

        // then
        var exercise = routine.get(0);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);

        exercise = routine.get(1);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);

        exercise = routine.get(2);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, LEGS, 1, 2);

        exercise = routine.get(3);
        assertEquals(3, exercise.size());
        assertRolesByType(exercise, SHOULDERS, 1, 2);

        exercise = routine.get(4);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, TRICEPS, 1, 2);
        assertRolesByType(exercise, CORE, 1, 2);

        exercise = routine.get(5);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, CHEST, 1, 2);
        assertRolesByType(exercise, BICEPS, 1, 2);

        exercise = routine.get(6);
        assertEquals(6, exercise.size());
        assertRolesByType(exercise, BACK, 1, 2);
        assertRolesByType(exercise, LEGS, 1, 2);
    }

    void assertRolesByType(List<Exercise> routine, ExerciseType type, int main, int complementary) {
        assertFalse(routine.isEmpty());
        var mainExercise = routine.stream()
                .filter(e -> e.getType() == type && e.getRole() == ExerciseRole.MAIN)
                .count();
        assertEquals(main, mainExercise);
        var complementaryExercise = routine.stream()
                .filter(e -> e.getType() == type && e.getRole() == ExerciseRole.COMPLEMENTARY)
                .count();
        assertEquals(complementary, complementaryExercise);
    }

}