package com.example.routineclient;

import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import com.example.routineclient.dtos.Routine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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

    public Routine getRoutine(UUID routineId, String jwtToken) {
        final var request = new Request.Builder()
                .addHeader("Authorization", jwtToken)
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

    public UUID create(Routine routine, String jwtToken) throws JsonProcessingException {
        final var request = new Request.Builder()
                .url(baseUrl + "/routine")
                .addHeader("Authorization", jwtToken)
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
        Request request = new Request.Builder()
                .url(baseUrl + "/routine/exercise")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            if (response.body() == null) {
                throw new IOException("Response body is null");
            }

            // Specify the correct type information for deserialization
            TypeReference<Map<ExerciseType, List<ExerciseResponse>>> typeRef
                    = new TypeReference<>() {
            };
            return objectMapper.readValue(response.body().byteStream(), typeRef);
        } catch (IOException e) {
            // Consider logging the error or throw a more specific exception
            throw new RuntimeException("Error fetching exercises: " + e.getMessage(), e);
        }
    }

    public Optional<Routine> getLatest(String  jwtToken) {
        final var request = new Request.Builder()
                .addHeader("Authorization", jwtToken)
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
