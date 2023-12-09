package edu.uoc.workoutwizardroutinemanagment.service;

import edu.uoc.workoutwizardroutinemanagment.controller.dtos.ExerciseResponse;
import edu.uoc.workoutwizardroutinemanagment.domain.Exercise;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ExerciseService {

    public static Map<ExerciseType, List<ExerciseResponse>> getExercisesByType() {
        return Arrays.stream(Exercise.values()).map(exercise -> ExerciseResponse.builder()
                .type(exercise.getType())
                .name(exercise.getName())
                .build())
                .collect(groupingBy(ExerciseResponse::getType));
    }

}
