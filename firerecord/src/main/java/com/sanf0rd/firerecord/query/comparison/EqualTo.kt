package com.sanf0rd.firerecord.query.comparison

import com.sanf0rd.firerecord.FireRecord
import com.sanf0rd.firerecord.FireRecordComparisonQuery
import java.util.*
import kotlin.reflect.KMutableProperty1

infix fun <T : FireRecord> KMutableProperty1<T, String?>.equalTo(value: String): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Int?>.equalTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Date?>.equalTo(value: Date): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}

infix fun <T : FireRecord> KMutableProperty1<T, Boolean?>.equalTo(value: Boolean): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, QueryType.EqualTo)
}

