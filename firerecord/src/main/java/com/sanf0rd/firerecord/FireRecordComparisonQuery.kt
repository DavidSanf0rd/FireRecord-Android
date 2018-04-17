package com.sanf0rd.firerecord

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Query
import com.sanf0rd.firerecord.QueryType.*
import kotlin.reflect.KMutableProperty1

class FireRecordComparisonQuery<R : FireRecord>(val prop: KMutableProperty1<R, out Int?>,
                                                val value: Int, val type: QueryType) {

    fun buildFirestoreQuery(currentQuery: Query) = when (type) {
        EqualTo -> currentQuery.whereEqualTo(prop.name, value)
        GreaterThan -> currentQuery.whereGreaterThan(prop.name, value)
        GreaterThanOrEqualTo -> currentQuery.whereGreaterThanOrEqualTo(prop.name, value)
        LessThanOrEqualTo -> currentQuery.whereLessThanOrEqualTo(prop.name, value)
        LessThan -> currentQuery.whereLessThan(prop.name, value)
    }

    fun buildFirstQuery(collectionRef: CollectionReference) = when (type) {
        EqualTo -> collectionRef.whereEqualTo(prop.name, value)
        GreaterThan -> collectionRef.whereGreaterThan(prop.name, value)
        GreaterThanOrEqualTo -> collectionRef.whereGreaterThanOrEqualTo(prop.name, value)
        LessThanOrEqualTo -> collectionRef.whereLessThanOrEqualTo(prop.name, value)
        LessThan -> collectionRef.whereLessThan(prop.name, value)
    }
}

infix fun <T : FireRecord> KMutableProperty1<T, out Int?>.equalTo(value: Int): FireRecordComparisonQuery<T> {
    return FireRecordComparisonQuery(this, value, EqualTo)
}