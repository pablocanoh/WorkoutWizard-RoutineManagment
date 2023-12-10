package com.example.routineclient.dtos;

import java.util.List;
import java.util.UUID;

public record Routine(UUID id, List<RoutineDay> blocks) {

    public int getDays() {
        return blocks.size();
    }
}