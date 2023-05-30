package com.mrossello.repcounter.feature_repcounter.domain.use_cases

import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise
import com.mrossello.repcounter.feature_repcounter.domain.model.InvalidExercise
import com.mrossello.repcounter.feature_repcounter.domain.repository.ExerciseRepository

class ModifyExercise(
    private val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(
        exercise: Exercise
    ): Int {
        // validate fields
        if (exercise.count <= 0){
            throw InvalidExercise("Invalid rep count")
        }
        if (exercise.name.isBlank()){
            throw InvalidExercise("Invalid exercise name")
        }
        // insert data
        return exerciseRepository.insertexercise(exercise).toInt()
    }
}