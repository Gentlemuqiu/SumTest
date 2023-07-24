package com.example.lib.api

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

fun Share2(context: Activity) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"// 指定类型是纯文本分享
    intent.putExtra(Intent.EXTRA_SUBJECT, "标题")
    context.startActivity(Intent.createChooser(intent, "分享"))
}