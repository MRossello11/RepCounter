package com.mrossello.repcounter.feature_repcounter.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepCounterScreen(
    viewModel: RepCounterViewModel
) {
    val stateFlow by viewModel.stateFlow.collectAsState()
    var sliderPos by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // exercise name
            TextField(
                value = stateFlow.currentExercise.name,
                onValueChange = {
                    viewModel.onEvent(RepCounterEvents.ChangeName(it))
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // count
            Text(
                text = sliderPos.roundToInt().toString()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // slider to select count
            Slider(
                value = sliderPos,
                onValueChange = {
                    sliderPos = it
                },
                onValueChangeFinished = {
                    viewModel.onEvent(RepCounterEvents.ChangeCounter(sliderPos.roundToInt()))
                },
                valueRange = 0f..100f
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                // delete button
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    ),
                    onClick = {
                        viewModel.onEvent(RepCounterEvents.DeleteExercise(stateFlow.currentExercise))
                    }
                ) {
                    Text(text = "Delete")
                }

                Spacer(modifier = Modifier.width(20.dp))

                // submit button
                Button(
                    onClick = {
                        viewModel.onEvent(
                            RepCounterEvents.UpdateExercise(
                                stateFlow.currentExercise.copy(
                                    count = sliderPos.roundToInt()
                                )
                            )
                        )
                    }
                ) {
                    Text(text = "Submit")
                }
            }

            Spacer(modifier = Modifier.height(75.dp))

        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Top
        ){
            items(stateFlow.exerciseList) { exercise ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = exercise.name,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Reps: ${exercise.count}",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}