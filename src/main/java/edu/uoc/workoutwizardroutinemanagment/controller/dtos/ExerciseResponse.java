package edu.uoc.workoutwizardroutinemanagment.controller.dtos;

import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExerciseResponse {
    private ExerciseType type;
    private String name;
}
