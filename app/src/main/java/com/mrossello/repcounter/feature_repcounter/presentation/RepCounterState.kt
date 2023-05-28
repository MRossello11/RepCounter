package com.mrossello.repcounter.feature_repcounter.presentation

import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise

data class RepCounterState(
    val currentExercise: Exercise = Exercise(),
    val exerciseList: ArrayList<Exercise> = arrayListOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepCounterState

        if (currentExercise != other.currentExercise) return false
        if (exerciseList.size != other.exerciseList.size) return false

        for (index in exerciseList.indices) {
            val exercise = exerciseList[index]
            val otherExercise = other.exerciseList[index]
            if (exercise != otherExercise || exercise.count != otherExercise.count) {
                return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var result = currentExercise.hashCode()
        result = 31 * result + exerciseList.hashCode()
        return result
    }
}
