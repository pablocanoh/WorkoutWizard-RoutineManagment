package edu.uoc.workoutwizardroutinemanagment.controller;

import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import com.example.routineclient.dtos.Routine;
import edu.uoc.workoutwizardroutinemanagment.mappers.RoutineDomainToClient;
import edu.uoc.workoutwizardroutinemanagment.service.ExerciseService;
import edu.uoc.workoutwizardroutinemanagment.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static edu.uoc.workoutwizardroutinemanagment.mappers.RoutineDomainToClient.transform;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/routine")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    @GetMapping("/suggest")
    public Routine suggest(@RequestParam ExperienceLevel experienceLevel, @RequestParam int daysPerWeek) {
        return transform(RoutineService.generateRoutine(daysPerWeek, experienceLevel));
    }

    @GetMapping("/{routineId}")
    public Routine get(@PathVariable UUID routineId) {
        return transform(routineService.get(routineId));
    }


    @GetMapping("/latest")
    public Optional<Routine> getLates() {
        return routineService.getLatest().map(RoutineDomainToClient::transform);
    }

    @GetMapping("/exercise")
    public Map<ExerciseType, List<ExerciseResponse>> exercise() {
        return ExerciseService.getExercisesByType();
    }

    @PostMapping
    public UUID create(@RequestBody Routine routine) {
        return routineService.save(transform(routine));
    }
}
