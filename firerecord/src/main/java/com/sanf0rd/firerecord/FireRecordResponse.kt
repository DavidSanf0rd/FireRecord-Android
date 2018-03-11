package com.sanf0rd.firerecord

/**
 * Created by sanf0rd on 11/03/18.
 */
sealed class FireRecordResponse<T>
data class Sucess<T>(val result: T): FireRecordResponse<T>()
data class Failure<T>(val error: Exception? = null): FireRecordResponse<T>()