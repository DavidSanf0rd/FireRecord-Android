package com.sanf0rd.firerecord

import com.google.firebase.firestore.Query
import com.sanf0rd.firerecord.QueryType.*

enum class QueryType {
    EqualTo,
    GreaterThan,
    GreaterThanOrEqualTo,
    LessThanOrEqualTo,
    LessThan;
}