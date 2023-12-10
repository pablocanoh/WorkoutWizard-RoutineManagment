package com.example.routineclient.dtos;

import lombok.Getter;

@Getter
public enum Exercise {
    // Chest exercises
    CHEST_PRESS(ExerciseType.CHEST, "Chest Press", "Chest Press Description", ExerciseRole.MAIN),
    INCLINE_CHEST_PRESS(ExerciseType.CHEST, "Incline Chest Press", "Incline Chest Press Description", ExerciseRole.MAIN),
    DECLINE_CHEST_PRESS(ExerciseType.CHEST, "Decline Chest Press", "Decline Chest Press Description", ExerciseRole.MAIN),
    PULL_OVER(ExerciseType.CHEST, "Pull Over", "Pull Over Description", ExerciseRole.COMPLEMENTARY),
    FLY_CHEST(ExerciseType.CHEST, "Fly Chest", "Isolates chest muscles with a focus on pectorals.", ExerciseRole.COMPLEMENTARY),
    CABLE_CROSSOVER(ExerciseType.CHEST, "Cable Crossover", "Works lower chest muscles using a cable machine.", ExerciseRole.COMPLEMENTARY),
    DUMBBELL_PULLOVER(ExerciseType.CHEST, "Dumbbell Pullover", "Works upper chest muscles using a dumbbell.", ExerciseRole.COMPLEMENTARY),

    // Back exercises
    DEADLIFT(ExerciseType.BACK, "Deadlift", "Deadlift Description", ExerciseRole.MAIN),
    LAT_PULLDOWN(ExerciseType.BACK, "Lat Pulldown", "Lat Pulldown Description", ExerciseRole.MAIN),
    BENT_OVER_ROW(ExerciseType.BACK, "Bent Over Row", "Bent Over Row Description", ExerciseRole.MAIN),
    SEATED_ROW(ExerciseType.BACK, "Seated Row", "Seated Row Description", ExerciseRole.COMPLEMENTARY),
    PULL_UP(ExerciseType.BACK, "Pull Up", "Upper body exercise targeting back and biceps.", ExerciseRole.COMPLEMENTARY),
    T_BAR_ROW(ExerciseType.BACK, "T-Bar Row", "Compound exercise focusing on all parts of the back.", ExerciseRole.COMPLEMENTARY),

    // Leg exercises
    SQUAT(ExerciseType.LEGS, "Squat", "Squat Description", ExerciseRole.MAIN),
    LEG_PRESS(ExerciseType.LEGS, "Leg Press", "Leg Press Description", ExerciseRole.MAIN),
    LUNGES(ExerciseType.LEGS, "Lunges", "Lunges Description", ExerciseRole.MAIN),
    LEG_CURL(ExerciseType.LEGS, "Leg Curl", "Leg Curl Description", ExerciseRole.COMPLEMENTARY),
    CALF_RAISE(ExerciseType.LEGS, "Calf Raise", "Isolates the calf muscles for strength and definition.", ExerciseRole.COMPLEMENTARY),
    HIP_THRUST(ExerciseType.LEGS, "Hip Thrust", "Targets glutes and hamstrings for lower body strength.", ExerciseRole.COMPLEMENTARY),

    // Shoulder exercises
    SHOULDER_PRESS(ExerciseType.SHOULDERS, "Shoulder Press", "Shoulder Press Description", ExerciseRole.MAIN),
    LATERAL_RAISE(ExerciseType.SHOULDERS, "Lateral Raise", "Lateral Raise Description", ExerciseRole.COMPLEMENTARY),
    FRONT_RAISE(ExerciseType.SHOULDERS, "Front Raise", "Front Raise Description", ExerciseRole.COMPLEMENTARY),
    UPRIGHT_ROW(ExerciseType.SHOULDERS, "Upright Row", "Targets shoulders and traps for upper body strength.", ExerciseRole.COMPLEMENTARY),
    REAR_DELT_FLY(ExerciseType.SHOULDERS, "Rear Delt Fly", "Focuses on the posterior deltoids.", ExerciseRole.COMPLEMENTARY),

    // Biceps exercises
    BICEP_CURL(ExerciseType.BICEPS, "Bicep Curl", "Bicep Curl Description", ExerciseRole.MAIN),
    HAMMER_CURL(ExerciseType.BICEPS, "Hammer Curl", "Hammer Curl Description", ExerciseRole.COMPLEMENTARY),
    PREACHER_CURL(ExerciseType.BICEPS, "Preacher Curl", "Preacher Curl Description", ExerciseRole.COMPLEMENTARY),
    CONCENTRATION_CURL(ExerciseType.BICEPS, "Concentration Curl", "Isolates biceps for focused muscle growth.", ExerciseRole.COMPLEMENTARY),
    BARBELL_CURL(ExerciseType.BICEPS, "Barbell Curl", "Classic bicep exercise for mass and strength.", ExerciseRole.COMPLEMENTARY),

    // Triceps exercises
    TRICEPS_EXTENSION(ExerciseType.TRICEPS, "Triceps Extension", "Triceps Extension Description", ExerciseRole.MAIN),
    SKULL_CRUSHER(ExerciseType.TRICEPS, "Skull Crusher", "Skull Crusher Description", ExerciseRole.COMPLEMENTARY),
    TRICEPS_DIP(ExerciseType.TRICEPS, "Triceps Dip", "Triceps Dip Description", ExerciseRole.COMPLEMENTARY),
    OVERHEAD_TRICEPS_EXTENSION(ExerciseType.TRICEPS, "Overhead Triceps Extension", "Targets the triceps, emphasizing the long head.", ExerciseRole.COMPLEMENTARY),
    DIAMOND_PUSH_UP(ExerciseType.TRICEPS, "Diamond Push-Up", "Bodyweight exercise focusing on triceps and chest.", ExerciseRole.COMPLEMENTARY),

    // Core exercises
    SIT_UP(ExerciseType.CORE, "Sit Up", "Classic abdominal exercise for core strength.", ExerciseRole.MAIN),
    PLANK(ExerciseType.CORE, "Plank", "Core stabilization exercise that targets the entire abdominal region.", ExerciseRole.MAIN),
    LEG_RAISE(ExerciseType.CORE, "Leg Raise", "Targets lower abdominals and hip flexors.", ExerciseRole.COMPLEMENTARY),
    RUSSIAN_TWIST(ExerciseType.CORE, "Russian Twist", "Works the obliques for core rotation strength.", ExerciseRole.COMPLEMENTARY);

    private final ExerciseRole role;
    private final ExerciseType type;
    private final String name;
    private final String description;

    Exercise(ExerciseType exerciseType, String name, String description, ExerciseRole role) {
        this.type = exerciseType;
        this.role = role;
        this.name = name;
        this.description = description;
    }
}
