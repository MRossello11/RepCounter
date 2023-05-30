package com.mrossello.repcounter.feature_repcounter.data.data_source

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise

interface ExerciseDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertExercise(exercise: Exercise): Long

    @Query("select * from ${Exercise.TABLE_NAME}")
    suspend fun getExercises(): List<Exercise>

    @Query("delete from ${Exercise.TABLE_NAME} where id = :exerciseId")
    suspend fun deleteExercise(exerciseId: Int)
}