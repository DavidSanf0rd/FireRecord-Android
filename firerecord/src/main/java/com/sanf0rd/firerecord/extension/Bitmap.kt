package com.sanf0rd.firerecord.extension

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

fun Bitmap.toByteArray(format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
                       quality: Int = 100 ): ByteArray {

    val outputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    return outputStream.toByteArray()
}