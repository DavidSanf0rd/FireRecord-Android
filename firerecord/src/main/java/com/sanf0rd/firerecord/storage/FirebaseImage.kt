package com.sanf0rd.firerecord.storage

import android.graphics.Bitmap
import com.sanf0rd.firerecord.extension.toByteArray

abstract class FirebaseImage(bitmap: Bitmap? = null) : FirebaseFile() {
    var bitmap: Bitmap? = bitmap
    set(value)  { data = value?.toByteArray() }
}