package edu.uoc.workoutwizardroutinemanagment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routine_days")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoutineDay {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "routine_day_id")
    private List<ExerciseWithReps> exercises;
}
