package com.sanf0rd.firerecord

import kotlin.reflect.KMutableProperty1

class FireRecordComparisonQuery<R: FireRecord>(val prop: KMutableProperty1<R, out Int?>,
                                               val value: Int, val type: QueryType)

infix fun <T: FireRecord> KMutableProperty1<T, out Int?>.equalTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}