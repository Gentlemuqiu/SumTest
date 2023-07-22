package com.example.lib.api

import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToFormattedDateTime(timestamp: Long): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = timestamp

    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault())

    return dateFormat.format(calendar.time)
}
