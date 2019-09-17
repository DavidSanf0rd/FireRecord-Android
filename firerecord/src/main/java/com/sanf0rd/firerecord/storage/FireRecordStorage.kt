package com.sanf0rd.firerecord.storage

import com.google.firebase.storage.FirebaseStorage
import com.sanf0rd.firerecord.FireRecord

val firebaseStorage = FirebaseStorage.getInstance()

class FireRecordStorage {

    companion object {

        fun checkForFiles(instance: FireRecord) {
            val instanceClass = instance::class.java
            instanceClass.declaredFields.forEach { field ->
                if (field.type.superclass.isAssignableFrom(FirebaseFile::class.java)) {
                    println(field)
                    //Todo: Fix error getting image from instance.
                    //sendImageToFirebase(field.get(instance) as FirebaseFile)
                }
            }
        }

        fun sendImageToFirebase(file: FirebaseFile) {
            val imageRef = firebaseStorage.reference.child("mountains.jpg")

            val uploadTask = imageRef.putBytes(file.data!!)
            uploadTask.addOnFailureListener { error ->
                print(error)
            }.addOnSuccessListener { snapshot ->
                print(snapshot)
            }
        }
    }
}