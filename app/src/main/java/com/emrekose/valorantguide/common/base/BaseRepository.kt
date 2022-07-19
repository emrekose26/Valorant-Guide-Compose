package com.emrekose.valorantguide.common.base

import com.emrekose.valorantguide.common.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.io.IOException


abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<T>
    ): Flow<Result<T?>> =
        flow {
            emit(Result.Loading)
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Result.Success(response.body()))
                } else {
                    val errorBody = response.errorBody()
                    if (errorBody != null) {
                        emit(Result.Error(IOException(errorBody.toString())))
                    } else {
                        emit(Result.Error(IOException("Something went wrong")))
                    }
                }
            } else {
                emit(Result.Error(Throwable(response.errorBody().toString())))
            }
        }.catch { error ->
            error.printStackTrace()
            emit(Result.Error(Exception(error)))
        }.flowOn(dispatcher)
}