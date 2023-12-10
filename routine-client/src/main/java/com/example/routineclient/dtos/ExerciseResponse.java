package com.example.routineclient.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExerciseResponse {
    private ExerciseType type;
    private String name;
}
