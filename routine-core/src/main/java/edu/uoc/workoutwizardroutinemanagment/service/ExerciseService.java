package edu.uoc.workoutwizardroutinemanagment.service;

import com.example.routineclient.dtos.Exercise;
import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;

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
