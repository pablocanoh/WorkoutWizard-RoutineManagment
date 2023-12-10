package com.example.routineclient.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseWithReps {

    private UUID id;
    private ExerciseType type;
    private ExerciseRole role;
    private String name;
    private String description;
    private int sets;
    private int reps;

    public static class ExerciseWithRepsBuilder {
        private ExerciseType type;
        private String name;
        private String description;
        private int sets;
        private int reps;

        public ExerciseWithRepsBuilder exercise(Exercise exercise) {
            this.type = exercise.getType();
            this.name = exercise.getName();
            this.description = exercise.getDescription();
            this.role = exercise.getRole();
            return this;
        }

        public ExerciseWithRepsBuilder withExpertise(ExperienceLevel level) {
            switch (level) {
                case BEGINNER:
                    this.sets = 3;
                    this.reps = 12;
                    break;
                case INTERMEDIATE:
                    this.sets = 4;
                    this.reps = 10;
                    break;
                case ADVANCED:
                    this.sets = 5;
                    this.reps = 8;
                    break;
            }

            return this;
        }
    }
}
