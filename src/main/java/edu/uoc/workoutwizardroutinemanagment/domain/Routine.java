package edu.uoc.workoutwizardroutinemanagment.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Routine {
    private final List<RoutineDay> blocks;
}
