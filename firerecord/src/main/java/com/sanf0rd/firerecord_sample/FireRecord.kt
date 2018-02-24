package com.sanf0rd.firerecord_sample

import android.util.Log

/**
 * Created by sanf0rd on 24/02/18.
 */
open class FireRecord {
    companion object {
        fun printMyName() {
            print("trying")
        }
    }
}

open class FireRecordCompanion {

    fun all() {
        val callingClass = Class.forName(this.javaClass.name.removeSuffix("\$Companion")).kotlin
    }
}