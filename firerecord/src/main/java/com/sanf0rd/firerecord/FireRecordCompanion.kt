package com.sanf0rd.firerecord

/**
 * Created by sanf0rd on 11/03/18.
 */
open class FireRecordCompanion<T: FireRecord>

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.load(id: String, crossinline result: (FireRecordResponse<U>) -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").document(id).get()
            .addOnCompleteListener { task ->
                val taskResult = task.result ?: return@addOnCompleteListener result(Failure())

                if (task.isSuccessful && taskResult.exists()) {
                    val mappedObject = taskResult.toObject(U::class.java)
                            ?: throw IllegalStateException("mapped object cannot be null")
                    mappedObject.id = id
                    result(Success(mappedObject))
                }else {
                    result(Failure())
                }
            }
}

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.all(crossinline result: (FireRecordResponse<List<U>>) -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val taskResult = task.result ?: return@addOnCompleteListener result(Failure())
                    val documents = taskResult.documents

                    val mappedList = documents.map {
                        val mappedObject = it.toObject(U::class.java)
                                ?: throw IllegalStateException("mapped object cannot be null")
                        mappedObject.id = it.id
                        return@map mappedObject
                    }

                    result(Success(mappedList))
                } else {
                    result(Failure())
                }
            }
}

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.destroy(id: String, crossinline result: (FireRecordResponse<Unit>) -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").document(id).delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val unitRef = {}()
                    result(Success(unitRef))
                } else {
                    result(Failure())
                }
            }
}