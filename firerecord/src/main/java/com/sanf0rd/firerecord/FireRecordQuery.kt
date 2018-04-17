package com.sanf0rd.firerecord

fun <T: FireRecordCompanion<R>, R: FireRecord> T.where(query: FireRecordComparisonQuery<R>): FireRecordQuery<R> {
    print(query.value)
    return FireRecordQuery()
}

class FireRecordQuery<T: FireRecord> {
    private val queryList = mutableListOf<FireRecordComparisonQuery<T>>()

    fun where(query: FireRecordComparisonQuery<T>): FireRecordQuery<T> {
        queryList.add(query)
        return this
    }

    fun take(){

    }

    fun takeAll() {

    }
}