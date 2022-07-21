package com.emrekose.valorantguide.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform


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

fun <T> Flow<Result<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<Result<T>> =
    transform { value ->
        if (value is Result.Success) {
            action(value.data)
        }
        return@transform emit(value)
    }

fun <T> Flow<Result<T>>.doOnError(action: suspend (Throwable?) -> Unit): Flow<Result<T>> =
    transform { value ->
        if (value is Result.Error) {
            action(value.error)
        }
        return@transform emit(value)
    }

fun <T> Flow<Result<T>>.doOnLoading(action: suspend () -> Unit): Flow<Result<T>> =
    transform { value ->
        if (value is Result.Loading) {
            action()
        }
        return@transform emit(value)
    }