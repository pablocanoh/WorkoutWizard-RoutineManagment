package edu.uoc.workoutwizardroutinemanagment.controller;

import edu.uoc.workoutwizardroutinemanagment.controller.dtos.ExerciseResponse;
import edu.uoc.workoutwizardroutinemanagment.domain.Exercise;
import edu.uoc.workoutwizardroutinemanagment.domain.ExerciseType;
import edu.uoc.workoutwizardroutinemanagment.domain.ExperienceLevel;
import edu.uoc.workoutwizardroutinemanagment.domain.Routine;
import edu.uoc.workoutwizardroutinemanagment.service.ExerciseService;
import edu.uoc.workoutwizardroutinemanagment.service.RoutineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
}
