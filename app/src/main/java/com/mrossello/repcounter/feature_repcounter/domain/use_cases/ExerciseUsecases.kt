package com.mrossello.repcounter.feature_repcounter.domain.use_cases

data class ExerciseUsecases(
    val getExercises: GetExercises,
    val modifyExercise: ModifyExercise,
    val deleteExercises: DeleteExercises
)