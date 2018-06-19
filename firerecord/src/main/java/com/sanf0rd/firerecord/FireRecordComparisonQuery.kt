package com.sanf0rd.firerecord

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Query
import com.sanf0rd.firerecord.query.comparison.QueryType
import com.sanf0rd.firerecord.query.comparison.QueryType.*
import kotlin.reflect.KMutableProperty1

class FireRecordComparisonQuery<R : FireRecord>(val prop: KMutableProperty1<R, *>,
                                                val value: Any, val type: QueryType) {

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





