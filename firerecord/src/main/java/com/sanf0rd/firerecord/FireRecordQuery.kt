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
