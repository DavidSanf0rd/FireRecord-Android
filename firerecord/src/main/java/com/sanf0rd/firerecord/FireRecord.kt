package com.sanf0rd.firerecord

import com.google.firebase.firestore.FirebaseFirestore
import com.sanf0rd.firerecord.extension.reference


/**
 * Created by sanf0rd on 24/02/18.
 */

val firestore: FirebaseFirestore
    get() = FirebaseFirestore.getInstance()

open class FireRecord {

    var id: String? = null

    fun save(result: (FireRecordResponse<Unit>) -> Unit) {
        firestore.collection("/${this::class.java.simpleName.toLowerCase()}").add(this)
                .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                this.id = task.result.id
                result(Sucess(Unit.reference))
            }else {
                result(Failure())
            }
        }
    }

    fun update(result: (FireRecordResponse<Unit>) -> Unit) {
        val id = id ?: return //Todo: return an Error

        firestore.collection("/${this::class.java.simpleName.toLowerCase()}")
                .document(id).set(this).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result(Sucess(Unit.reference))
            } else {
                result(Failure())
            }
        }
    }

    fun destroy(result: (FireRecordResponse<Unit>) -> Unit) {
        val id = id ?: return //Todo: return an Error

        firestore.collection("/${this::class.java.simpleName.toLowerCase()}")
                .document(id).delete().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                result(Sucess(Unit.reference))
            } else {
                result(Failure())
            }
        }
    }
}
