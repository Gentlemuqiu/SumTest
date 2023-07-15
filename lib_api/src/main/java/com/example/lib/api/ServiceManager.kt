package com.example.lib.api

import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter
import kotlin.reflect.KClass

object ServiceManager {
    operator fun <T : Any> invoke(serviceClass: KClass<T>): T {
        return ARouter.getInstance().navigation(serviceClass.java)
    }
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> invoke(servicePath: String): T {
        return ARouter.getInstance().build(servicePath).navigation() as T
    }
}
val <T: IProvider> KClass<T>.impl: T
    get() = ServiceManager(this)