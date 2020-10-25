package com.allen.whitehorsestock.data.source

import me.goldze.mvvmhabit.utils.SPUtils


class LoginLocalDataSourceImpl :LoginLocalDataSource{
    @Volatile
    private var INSTANCE: LoginLocalDataSourceImpl? = null



    fun getInstance(): LoginLocalDataSourceImpl? {
        if (INSTANCE == null) {
            synchronized(LoginLocalDataSourceImpl::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = LoginLocalDataSourceImpl()
                }
            }
        }
        return INSTANCE
    }

    fun destroyInstance() {
        INSTANCE = null
    }

    override fun saveUserName(userName: String?) {
        SPUtils.getInstance().put("UserName", userName)
    }

    override fun savePassword(password: String?) {
        SPUtils.getInstance().put("password", password)
    }

    override fun getUserName(): String? {
        return SPUtils.getInstance().getString("UserName")
    }

    override fun getPassword(): String? {
        return SPUtils.getInstance().getString("password")
    }
}