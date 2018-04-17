package com.sanf0rd.firerecord

import kotlin.reflect.KClass

inline fun <T: FireRecordCompanion<R>,reified R: FireRecord> T.where(query: FireRecordComparisonQuery<R>): FireRecordQuery<R> {
    print(query.value)
    return FireRecordQuery(R::class).where(query)
}

class FireRecordQuery<T: FireRecord>(private val kClass: KClass<T>) {
    private val queryList = mutableListOf<FireRecordComparisonQuery<T>>()

    fun where(query: FireRecordComparisonQuery<T>): FireRecordQuery<T> {
        queryList.add(query)
        return this
    }

    private fun evaluate() {
        val collectionRef = firestore.collection("/${kClass.java.simpleName.toLowerCase()}")
        var firestoreQuery = queryList.first().buildFirstQuery(collectionRef)

        firestoreQuery = queryList.subList(1, queryList.size).fold(firestoreQuery) {
            currentQuery, fireRecordQuery -> fireRecordQuery.buildFirestoreQuery(currentQuery)
        }

        firestoreQuery.get().addOnCompleteListener {
            print(it)
        }
    }

    fun take() {

    }

    fun takeAll() {

    }
}