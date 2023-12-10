package edu.uoc.workoutwizardroutinemanagment.controller;

import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import edu.uoc.workoutwizardroutinemanagment.service.ExerciseService;
import edu.uoc.workoutwizardroutinemanagment.service.RoutineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/routine")
public class RoutineController {

    @GetMapping("/suggest")
    public Routine suggest(@RequestParam ExperienceLevel experienceLevel, @RequestParam int daysPerWeek) {
        return RoutineService.generateRoutine(daysPerWeek, experienceLevel);
    }

    @GetMapping("/exercise")
    public Map<ExerciseType, List<ExerciseResponse>> exercise() {
        return ExerciseService.getExercisesByType();
    }

    @PostMapping
    public UUID create(@RequestBody Routine routine) {
        System.out.println(routine);
        return UUID.randomUUID();
    }
}
