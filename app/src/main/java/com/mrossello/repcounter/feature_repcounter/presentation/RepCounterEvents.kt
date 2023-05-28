package com.mrossello.repcounter.feature_repcounter.presentation

import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise

sealed class RepCounterEvents{
    data class UpdateExercise(val exercise: Exercise): RepCounterEvents()
    data class DeleteExercise(val exercise: Exercise): RepCounterEvents()
    data class ChangeCounter(val newCountSelected: Int): RepCounterEvents()
    data class ChangeName(val newName: String): RepCounterEvents()
}
