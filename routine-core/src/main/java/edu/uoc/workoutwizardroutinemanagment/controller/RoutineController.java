package edu.uoc.workoutwizardroutinemanagment.controller;

import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import com.example.routineclient.dtos.Routine;
import edu.uoc.workoutwizardroutinemanagment.mappers.RoutineDomainToClient;
import edu.uoc.workoutwizardroutinemanagment.service.ExerciseService;
import edu.uoc.workoutwizardroutinemanagment.service.RoutineService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uoc.edu.commons.JwtTokenUtil;

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

    private final JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

    @GetMapping("/suggest")
    public Routine suggest(@RequestParam ExperienceLevel experienceLevel, @RequestParam int daysPerWeek) {
        return transform(RoutineService.generateRoutine(daysPerWeek, experienceLevel));
    }

    @GetMapping("/{routineId}")
    public Routine get(@PathVariable UUID routineId,  @RequestHeader("Authorization") String jwtToken) {
        final var userId = jwtTokenUtil.getUserIdFromToken(jwtToken);
        return transform(routineService.get(routineId, userId));
    }


    @GetMapping("/latest")
    public Optional<Routine> getLates(@RequestHeader("Authorization") String jwtToken) {
        final var userId = jwtTokenUtil.getUserIdFromToken(jwtToken);
        return routineService.getLatest(userId).map(RoutineDomainToClient::transform);
    }

    @GetMapping("/exercise")
    public Map<ExerciseType, List<ExerciseResponse>> exercise() {
        return ExerciseService.getExercisesByType();
    }

    @PostMapping
    public UUID create(@RequestBody Routine routine, @RequestHeader("Authorization") String jwtToken) {
        final var userId = jwtTokenUtil.getUserIdFromToken(jwtToken);
        return routineService.save(transform(routine, userId), jwtToken);
    }
}
