package com.sanf0rd.firerecord

import kotlin.reflect.KClass

inline fun <T: FireRecordCompanion<R>, reified R: FireRecord> T.where(query: FireRecordComparisonQuery<R>): FireRecordQuery<R> {
    print(query.value)
    return FireRecordQuery(R::class).where(query)
}

class FireRecordQuery<T: FireRecord>(private val kClass: KClass<T>) {
    private val queryList = mutableListOf<FireRecordComparisonQuery<T>>()

    fun where(query: FireRecordComparisonQuery<T>): FireRecordQuery<T> {
        queryList.add(query)
        return this
    }

    private fun evaluate(result: (FireRecordResponse<List<T>>) -> Unit) {
        val collectionRef = firestore.collection("/${kClass.java.simpleName.toLowerCase()}")
        var firestoreQuery = queryList.first().buildFirstQuery(collectionRef)

        firestoreQuery = queryList.subList(1, queryList.size).fold(firestoreQuery) {
            currentQuery, fireRecordQuery -> fireRecordQuery.buildFirestoreQuery(currentQuery)
        }

        firestoreQuery.get().addOnCompleteListener { task ->

            if (task.isSuccessful) {
                val result = requireNotNull(task.result) { "Result cannot be null" }
                val documents = result.documents

                val mappedList = documents.mapNotNull {
                    val mappedObject = it.toObject(kClass.java) ?: return@mapNotNull null
                    mappedObject.id = it.id
                    return@mapNotNull mappedObject
                }

                result(Success(mappedList))
            } else {
                result(Failure())
            }
        }
    }

    fun take(result: (FireRecordResponse<List<T>>) -> Unit) = evaluate(result)

    fun takeAll() {

    }
}