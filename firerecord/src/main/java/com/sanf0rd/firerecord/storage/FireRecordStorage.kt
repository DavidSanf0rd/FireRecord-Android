package com.sanf0rd.firerecord.storage

import android.graphics.Bitmap
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import com.sanf0rd.firerecord.FireRecord
import java.io.ByteArrayOutputStream

val firebaseStorage = FirebaseStorage.getInstance()

class FireRecordStorage {

    companion object {

        fun checkForFiles(instance: FireRecord) {
            val instanceClass = instance::class.java
            instanceClass.declaredFields.forEach { field ->
                if (field.type.superclass.isAssignableFrom(FirebaseFile::class.java)) {
                    println(field)
                    sendImageToFirebase(field.get(instance))
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