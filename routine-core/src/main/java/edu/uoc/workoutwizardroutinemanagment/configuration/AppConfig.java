package edu.uoc.workoutwizardroutinemanagment.configuration;

import com.example.workoutclient.dto.WorkoutClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WorkoutClient routineClient() {
        return new WorkoutClient("http://localhost:8080");
    }
}
