package com.sanf0rd.firerecord_sample

import android.util.Log

/**
 * Created by sanf0rd on 24/02/18.
 */
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