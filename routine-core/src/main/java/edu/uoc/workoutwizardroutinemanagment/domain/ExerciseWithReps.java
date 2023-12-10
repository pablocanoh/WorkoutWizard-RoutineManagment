package edu.uoc.workoutwizardroutinemanagment.domain;

import com.example.routineclient.dtos.Exercise;
import com.example.routineclient.dtos.ExerciseRole;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseWithReps {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "type", nullable = false)
    private ExerciseType type;

    @Column(name = "role", nullable = false)
    private ExerciseRole role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "sets", nullable = false)
    private int sets;

    @Column(name = "reps", nullable = false)
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
