package com.example.sumtest

import android.app.Application

open class BaseApp: Application() {
    companion object {
        lateinit var mContext: BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        mContext=this
    }
}