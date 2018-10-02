package com.sanf0rd.firerecord.storage

import com.google.firebase.storage.FirebaseStorage
import com.sanf0rd.firerecord.FireRecord

val firebaseStorage = FirebaseStorage.getInstance()

class FireRecordStorage {

    companion object {

        fun checkForFiles(instance: FireRecord) {
            val instanceClass = instance::class.java
            instanceClass.declaredFields.forEach { field ->
                if (field.type.isAssignableFrom(FirebaseImage::class.java)) {
                    println(field)
                }
            }
        }
    }
}