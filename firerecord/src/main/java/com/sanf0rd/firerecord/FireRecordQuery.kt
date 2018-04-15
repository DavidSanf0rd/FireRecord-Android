package com.sanf0rd.firerecord

import kotlin.reflect.KMutableProperty1

enum class QueryType {
    EqualTo,
    GreaterThan,
    GreaterThanOrEqualTo,
    LessThanOrEqualTo,
    LessThan
}

class FireRecordComparisonQuery<R: FireRecord>(val prop: KMutableProperty1<R ,out Int?>,
                                               val value: Int, val type: QueryType)

infix fun <T: FireRecord> KMutableProperty1<T, out Int?>.equalTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}

fun <T: FireRecordCompanion<R>, R: FireRecord> T.where(query: FireRecordComparisonQuery<R>) {
    print(query.value)
}