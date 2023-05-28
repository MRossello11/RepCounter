package com.mrossello.repcounter.feature_repcounter.presentation

import androidx.lifecycle.ViewModel
import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise
import com.mrossello.repcounter.feature_repcounter.presentation.RepCounterEvents.ChangeCounter
import com.mrossello.repcounter.feature_repcounter.presentation.RepCounterEvents.ChangeName
import com.mrossello.repcounter.feature_repcounter.presentation.RepCounterEvents.DeleteExercise
import com.mrossello.repcounter.feature_repcounter.presentation.RepCounterEvents.UpdateExercise
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RepCounterViewModel: ViewModel() {
    private val _stateFlow = MutableStateFlow(RepCounterState())
    val stateFlow: StateFlow<RepCounterState> = _stateFlow.asStateFlow()

    fun onEvent(event: RepCounterEvents){
        when(event){
            is UpdateExercise -> {
                val indexOfExercise = _stateFlow.value.exerciseList.indexOf(event.exercise)
                val newExerciseList = arrayListOf<Exercise>()
                newExerciseList.addAll(_stateFlow.value.exerciseList)
                if (indexOfExercise == -1){
                    // add new exercise
                    newExerciseList.add(event.exercise)
                } else {
                    // modify exercise
                    newExerciseList[indexOfExercise] = event.exercise
                }

                _stateFlow.value = stateFlow.value.copy(
                    exerciseList = newExerciseList
                )
            }

            is DeleteExercise -> {
                val newExerciseList = arrayListOf<Exercise>()
                newExerciseList.addAll(_stateFlow.value.exerciseList)
                newExerciseList.remove(event.exercise)

                _stateFlow.value = stateFlow.value.copy(
                    exerciseList = newExerciseList
                )
            }
            is ChangeName -> {
                _stateFlow.value = stateFlow.value.copy(
                    currentExercise = stateFlow.value.currentExercise.copy(
                        name = event.newName
                    )
                )
            }
            is ChangeCounter -> {
                _stateFlow.value = stateFlow.value.copy(
                    currentExercise = stateFlow.value.currentExercise.copy(
                        count = event.newCountSelected
                    )
                )
            }
        }
    }
}