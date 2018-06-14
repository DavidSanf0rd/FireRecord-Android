package com.sanf0rd.firerecord.query.comparison

import com.sanf0rd.firerecord.FireRecord
import com.sanf0rd.firerecord.FireRecordComparisonQuery
import com.sanf0rd.firerecord.QueryType
import java.util.*
import kotlin.reflect.KMutableProperty1

infix fun <T : FireRecord> KMutableProperty1<T, String?>.lessThanOrEqualTo(value: String): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThanOrEqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Int?>.lessThanOrEqualTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThanOrEqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Date?>.lessThanOrEqualTo(value: Date): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThanOrEqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Boolean?>.lessThanOrEqualTo(value: Boolean): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThanOrEqualTo)
}

