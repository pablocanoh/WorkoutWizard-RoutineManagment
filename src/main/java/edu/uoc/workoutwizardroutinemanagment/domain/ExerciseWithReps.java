package edu.uoc.workoutwizardroutinemanagment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseWithReps {

    private ExerciseType type;
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

        public ExerciseWithRepsBuilder type(Exercise exercise) {
            this.type = exercise.getType();
            this.name = exercise.getName();
            this.description = exercise.getDescription();
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
