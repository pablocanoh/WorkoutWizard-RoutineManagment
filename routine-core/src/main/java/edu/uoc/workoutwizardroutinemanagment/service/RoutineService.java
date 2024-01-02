package edu.uoc.workoutwizardroutinemanagment.service;

import com.example.routineclient.dtos.ExperienceLevel;
import com.example.workoutclient.dto.WorkoutClient;
import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import edu.uoc.workoutwizardroutinemanagment.repositories.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private WorkoutClient workoutClient;

    @Autowired
    private RoutineGenerator routineGenerator;

    public Routine generateRoutine(int daysPerWeek, ExperienceLevel experienceLevel) {
        return routineGenerator.generateRoutine(daysPerWeek, experienceLevel);
    }

    public UUID save(Routine routine, String jwtToken) {
        final var newRoutineId = routineRepository.save(routine).getId();
        workoutClient.createWorkoutDiary(newRoutineId, jwtToken);
        return newRoutineId;
    }



    public Routine get(UUID routineId, UUID userId) {
        return routineRepository.findByIdAndUserId(routineId, userId).orElseThrow();
    }

    public Optional<Routine> getLatest(UUID userId) {
        return routineRepository.findFirstByUserIdOrderByCreatedDateDesc(userId);
    }
}
