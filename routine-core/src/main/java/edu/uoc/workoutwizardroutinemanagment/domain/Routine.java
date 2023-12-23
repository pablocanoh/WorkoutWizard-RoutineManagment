package edu.uoc.workoutwizardroutinemanagment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routines")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Routine {
    @Id
    @Column(name = "id", columnDefinition = "uuid", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Instant createdAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "routine_id")
    private List<RoutineDay> blocks;
}