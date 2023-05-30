package com.mrossello.repcounter.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrossello.repcounter.feature_repcounter.data.data_source.ExerciseDao
import com.mrossello.repcounter.feature_repcounter.domain.model.Exercise

@Database(entities = [Exercise::class], version = 1)
abstract class RepCounterDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao

    companion object{
        const val DB_NAME = "RepCounterDatabase"
    }
}