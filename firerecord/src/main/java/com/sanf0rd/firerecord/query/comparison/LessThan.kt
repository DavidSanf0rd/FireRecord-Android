package com.sanf0rd.firerecord.query.comparison

import com.sanf0rd.firerecord.FireRecord
import com.sanf0rd.firerecord.FireRecordComparisonQuery
import java.util.*
import kotlin.reflect.KMutableProperty1

infix fun <T : FireRecord> KMutableProperty1<T, String?>.lessThan(value: String): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Int?>.lessThan(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Date?>.lessThan(value: Date): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThan)
}

infix fun <T : FireRecord> KMutableProperty1<T, Boolean?>.lessThan(value: Boolean): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.LessThan)
}

