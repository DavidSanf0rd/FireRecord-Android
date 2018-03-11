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