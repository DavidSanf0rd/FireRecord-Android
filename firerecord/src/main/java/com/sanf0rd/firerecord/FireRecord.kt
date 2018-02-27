package com.sanf0rd.firerecord

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


/**
 * Created by sanf0rd on 24/02/18.
 */

val firestore: FirebaseFirestore
    get() = FirebaseFirestore.getInstance()

open class FireRecord {

    fun save(result: () -> Unit) {
        firestore.collection("/${this::class.java.simpleName.toLowerCase()}").add(this).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result()
            }else {
                //Todo: Return an Error
            }
        }
    }
}

open class FireRecordCompanion<T: FireRecord> { }

inline fun <reified U: FireRecord, T: FireRecordCompanion<U>> T.all(crossinline result: (List<U>) -> Unit) {

    firestore.collection("/${U::class.java.simpleName.toLowerCase()}").get().addOnCompleteListener { task ->
        if (task.isSuccessful) {
            result(task.result.toObjects(U::class.java) as List<U>)
        } else {
            Log.d("teste", "Error getting documents")
        }
    }
}