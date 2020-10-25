package com.allen.whitehorsestock.data.source

import com.allen.whitehorsestock.entity.LoginEntity
import io.reactivex.Observable
import me.goldze.mvvmhabit.http.BaseResponse




interface LoginHttpDataSource {
    //模拟登录
    fun login(): Observable<Any?>?

    //模拟上拉加载
    fun loadMore(): Observable<LoginEntity?>?

    fun demoGet(): Observable<BaseResponse<LoginEntity?>?>?

    fun demoPost(catalog: String?): Observable<BaseResponse<LoginEntity?>?>?
}