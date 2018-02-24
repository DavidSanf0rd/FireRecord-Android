package com.sanf0rd.firerecord

import com.google.firebase.firestore.FirebaseFirestore


/**
 * Created by sanf0rd on 24/02/18.
 */

val firestore: FirebaseFirestore
    get() = FirebaseFirestore.getInstance()

open class FireRecord {

    fun save() {
        print("your model has been saved")
    }
}

open class FireRecordCompanion {

    fun all() {
        val callingClass = Class.forName(this.javaClass.name.removeSuffix("\$Companion")).kotlin
    }
}