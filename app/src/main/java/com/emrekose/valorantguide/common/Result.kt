package com.emrekose.valorantguide.common


sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable?) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is Loading -> "Loading"
        }
    }
}

fun <T, R> Result<T>.map(transform: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Error -> Result.Error(error)
        is Result.Loading -> Result.Loading
    }
}