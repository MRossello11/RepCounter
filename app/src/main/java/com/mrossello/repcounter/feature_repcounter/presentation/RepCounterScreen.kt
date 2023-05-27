package com.mrossello.repcounter.feature_repcounter.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RepCounterScreen(

) {
    var count by remember{ mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = count.toString()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = {
                if (count > 0) {
                    count--
                }
            }) {
                Text(text = "-1")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                count++
            }) {
                Text(text = "+1")
            }
        }
    }
}