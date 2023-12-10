package com.example.routineclient.dtos;

import java.util.List;
import java.util.UUID;

public record RoutineDay(UUID id, List<ExerciseWithReps> exercises) {
}
