package edu.uoc.workoutwizardroutinemanagment.configuration;

import com.example.workoutclient.dto.WorkoutClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WorkoutClient routineClient(@Value("${workout-service.url}") String workoutServiceUrl) {
        return new WorkoutClient(workoutServiceUrl);
    }
}
