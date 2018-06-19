package com.sanf0rd.firerecord.storage

abstract class FirebaseFile {
    val path: String? = null
    var data: ByteArray? = null
}