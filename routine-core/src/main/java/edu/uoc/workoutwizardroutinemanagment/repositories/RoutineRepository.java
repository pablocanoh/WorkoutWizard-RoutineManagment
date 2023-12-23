package edu.uoc.workoutwizardroutinemanagment.repositories;

import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, UUID> {

    Optional<Routine> findTopByOrderByCreatedDateDesc();
}
