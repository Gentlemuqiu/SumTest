package com.example.lib.api

fun formatNumberToTime(number: Int): String {
    val minutes = number / 60
    val seconds = number % 60
    return "%02d:%02d".format(minutes, seconds)
}
