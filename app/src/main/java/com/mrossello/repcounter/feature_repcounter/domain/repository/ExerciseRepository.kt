package com.mrossello.repcounter.feature_repcounter.domain.repository

import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise

interface ExerciseRepository {
    suspend fun insertexercise(exercise: Exercise): Long
    suspend fun getExercies(): List<Exercise>
    suspend fun deleteExercise(exerciseId: Int)
}