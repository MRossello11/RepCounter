package com.mrossello.repcounter.feature_repcounter.data.repository

import com.mrossello.repcounter.feature_repcounter.data.data_source.ExerciseDao
import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise
import com.mrossello.repcounter.feature_repcounter.domain.repository.ExerciseRepository

class ExerciseRepositoryImpl(
    val exerciseDao: ExerciseDao
): ExerciseRepository {
    override suspend fun insertexercise(exercise: Exercise): Long {
        return exerciseDao.insertExercise(exercise)
    }

    override suspend fun getExercies(): List<Exercise> {
        return exerciseDao.getExercises()
    }

    override suspend fun deleteExercise(exerciseId: Int) {
        exerciseDao.deleteExercise(exerciseId)
    }
}