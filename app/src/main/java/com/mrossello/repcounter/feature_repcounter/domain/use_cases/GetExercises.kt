package com.mrossello.repcounter.feature_repcounter.domain.use_cases

import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise
import com.mrossello.repcounter.feature_repcounter.domain.repository.ExerciseRepository

class GetExercises(
    private val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(): List<Exercise>{
        return exerciseRepository.getExercies()
    }
}