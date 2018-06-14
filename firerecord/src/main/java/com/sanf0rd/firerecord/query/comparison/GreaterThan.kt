package com.sanf0rd.firerecord.query.comparison

import com.sanf0rd.firerecord.FireRecord
import com.sanf0rd.firerecord.FireRecordComparisonQuery
import com.sanf0rd.firerecord.QueryType
import java.util.*
import kotlin.reflect.KMutableProperty1

infix fun <T : FireRecord> KMutableProperty1<T, String?>.greaterThan(value: String): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Int?>.greaterThan(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Date?>.greaterThan(value: Date): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Boolean?>.greaterThan(value: Boolean): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.GreaterThan)
}

