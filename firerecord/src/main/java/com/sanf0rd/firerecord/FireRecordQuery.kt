package com.sanf0rd.firerecord

import kotlin.reflect.KMutableProperty1

fun <T: FireRecordCompanion<R>, R: FireRecord> T.where(query: FireRecordComparisonQuery<R>): FireRecordQuery<R> {
    print(query.value)
    return FireRecordQuery()
}

class FireRecordQuery<T: FireRecord> {
    fun where(query: FireRecordComparisonQuery<T>): FireRecordQuery<T> {
        return FireRecordQuery()
    }
}
