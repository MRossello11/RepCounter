package com.mrossello.repcounter.feature_repcounter.domain.use_cases

import com.mrossello.repcounter.feature_repcounter.domain.repository.ExerciseRepository

class DeleteExercises(
    private val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(exerciseId: Int) {
        exerciseRepository.deleteExercise(exerciseId)
    }
}