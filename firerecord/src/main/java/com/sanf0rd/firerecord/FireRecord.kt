package com.sanf0rd.firerecord

import com.google.firebase.firestore.FirebaseFirestore


/**
 * Created by sanf0rd on 24/02/18.
 */

val firestore: FirebaseFirestore
    get() = FirebaseFirestore.getInstance()

open class FireRecord {

    var id: String? = null

    fun save(result: () -> Unit) {
        firestore.collection("/${this::class.java.simpleName.toLowerCase()}").add(this)
                .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                this.id = task.result.id
                result()
            }else {
                //Todo: Return an Error
            }
        }
    }

    fun update(result: () -> Unit) {
        val id = id ?: return Unit //Todo: return an Error

        firestore.collection("/${this::class.java.simpleName.toLowerCase()}")
                .document(id).set(this).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result()
            } else {
                //Todo: Return an error
            }
        }
    }

    fun destroy(result: () -> Unit) {
        val id = id ?: return Unit //Todo: return an Error

        firestore.collection("/${this::class.java.simpleName.toLowerCase()}")
                .document(id).delete().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result()
            } else {
                //Todo: Return an error
            }
        }
    }
}

open class FireRecordCompanion<T: FireRecord> { }

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.load(id: String, crossinline result: (U) -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").document(id).get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val mappedObject = task.result.toObject(U::class.java)
                    mappedObject.id = id
                    result(mappedObject)
                }else {
                    //Todo: Return an Error
                }
            }

}

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.all(crossinline result: (List<U>) -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").get()
            .addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val documents = task.result.documents

            val mappedList = documents.map {
                val mappedObject = it.toObject(U::class.java)
                mappedObject.id = it.id
                return@map mappedObject
            }

            result(mappedList)
        } else {
            //Todo: Return an Error
        }
    }
}

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.destroy(id: String, crossinline result: () -> Unit) {
    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").document(id).delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result()
                } else {
                    //Todo: Return an Error
                }
            }
}