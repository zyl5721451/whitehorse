package com.allen.whitehorsestock.data.source

interface LoginLocalDataSource {
    /**
     * 保存用户名
     */
    fun saveUserName(userName: String?)

    /**
     * 保存用户密码
     */
    fun savePassword(password: String?)

    /**
     * 获取用户名
     */
    fun getUserName(): String?

    /**
     * 获取用户密码
     */
    fun getPassword(): String?
}