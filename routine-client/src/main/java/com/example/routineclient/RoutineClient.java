package com.example.routineclient;

import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import com.example.routineclient.dtos.Routine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class RoutineClient {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String baseUrl;

    public RoutineClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Routine getRoutine(UUID routineId) {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine/" + routineId)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            return objectMapper.readValue(response.body().byteStream(), Routine.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Routine suggest(ExperienceLevel experienceLevel, int daysPerWeek) {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine/suggest?experienceLevel=" + experienceLevel + "&daysPerWeek=" + daysPerWeek)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            return objectMapper.readValue(response.body().byteStream(), Routine.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UUID create(Routine routine) throws JsonProcessingException {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine")
                .post(okhttp3.RequestBody.create(
                        objectMapper.writeValueAsString(routine),
                        okhttp3.MediaType.parse("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            return objectMapper.readValue(response.body().byteStream(), UUID.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<ExerciseType, List<ExerciseResponse>> getExercise() {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine/exercise")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            return objectMapper.readValue(response.body().byteStream(), Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Routine> getLatest() {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine/latest")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            return Optional.ofNullable(objectMapper.readValue(response.body().byteStream(), Routine.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
