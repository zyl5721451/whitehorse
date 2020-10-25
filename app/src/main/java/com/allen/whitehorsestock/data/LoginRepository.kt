package com.allen.whitehorsestock.data

import androidx.annotation.NonNull
import com.allen.whitehorsestock.data.source.LoginHttpDataSource
import com.allen.whitehorsestock.data.source.LoginLocalDataSource
import com.allen.whitehorsestock.entity.LoginEntity
import io.reactivex.Observable
import me.goldze.mvvmhabit.base.BaseModel
import me.goldze.mvvmhabit.http.BaseResponse

class LoginRepository : BaseModel,LoginHttpDataSource, LoginLocalDataSource{
    @Volatile
    private var INSTANCE: LoginRepository? = null
    private var mHttpDataSource: LoginHttpDataSource? = null

    private var mLocalDataSource: LoginLocalDataSource? = null

    constructor(
        mHttpDataSource: LoginHttpDataSource?,
        mLocalDataSource: LoginLocalDataSource?
    ) : super() {
        this.mHttpDataSource = mHttpDataSource
        this.mLocalDataSource = mLocalDataSource
    }


    fun getInstance(
        httpDataSource: LoginHttpDataSource,
        localDataSource: LoginLocalDataSource
    ): LoginRepository? {
        if (INSTANCE == null) {
            synchronized(LoginRepository::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = LoginRepository(httpDataSource, localDataSource)
                }
            }
        }
        return INSTANCE
    }



    override fun login(): Observable<Any?>? {
        return mHttpDataSource?.login()
    }

    override fun loadMore(): Observable<LoginEntity?>? {
        return mHttpDataSource?.loadMore()
    }

    override fun demoGet(): Observable<BaseResponse<LoginEntity?>?>? {
        return mHttpDataSource?.demoGet()
    }

    override fun demoPost(catalog: String?): Observable<BaseResponse<LoginEntity?>?>? {
        return mHttpDataSource?.demoPost(catalog)
    }

    override fun saveUserName(userName: String?) {
        mLocalDataSource?.saveUserName(userName)
    }

    override fun savePassword(password: String?) {
        mLocalDataSource?.savePassword(password)
    }

    override fun getUserName(): String? {
        return mLocalDataSource?.getUserName()
    }

    override fun getPassword(): String? {
        return mLocalDataSource?.getPassword()
    }

}