package com.allen.whitehorsestock

import android.R
import me.goldze.mvvmhabit.base.BaseApplication
import me.goldze.mvvmhabit.crash.CaocConfig
import me.goldze.mvvmhabit.utils.KLog


class AppApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        //是否开启日志打印
        KLog.init(true)
        //配置全局异常崩溃操作
        CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
            .apply()
    }

}