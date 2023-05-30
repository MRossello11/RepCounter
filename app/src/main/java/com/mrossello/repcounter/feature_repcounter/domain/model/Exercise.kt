package com.mrossello.repcounter.feature_repcounter.domain.model

data class Exercise(
    val name: String = "",
    var count: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (other is Exercise){
            return this.name == other.name
        }
        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + count
        return result
    }
}

class InvalidExercise(message: String): Exception(message)