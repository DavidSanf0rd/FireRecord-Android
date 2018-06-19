package com.sanf0rd.firerecord.query.comparison

import com.sanf0rd.firerecord.FireRecord
import com.sanf0rd.firerecord.FireRecordComparisonQuery
import java.util.*
import kotlin.reflect.KMutableProperty1

infix fun <T : FireRecord> KMutableProperty1<T, String?>.greaterThanOrEqualTo(value: String): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Int?>.greaterThanOrEqualTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Date?>.greaterThanOrEqualTo(value: Date): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Boolean?>.greaterThanOrEqualTo(value: Boolean): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThanOrEqualTo)
}

