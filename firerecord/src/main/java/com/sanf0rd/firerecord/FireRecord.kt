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
        firestore.collection("/users").add(this).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result()
            }else {
                //Todo: Return an Error
            }
        }
        print("your model has been saved")
    }
}

open class FireRecordCompanion<T: FireRecord> { }

fun <U: FireRecord, T: FireRecordCompanion<U>> T.all(result: (List<U>) -> Unit) {

    val callingClass = Class.forName(this.javaClass.name.removeSuffix("\$Companion"))

    firestore.collection("/users").get().addOnCompleteListener { task ->
        if (task.isSuccessful) {
            result(task.result.toObjects(callingClass) as List<U>)
        } else {
            Log.d("teste", "Error getting documents")
        }
    }
}