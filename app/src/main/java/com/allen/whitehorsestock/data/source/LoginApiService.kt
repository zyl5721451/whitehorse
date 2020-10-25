package com.allen.whitehorsestock.data.source

import com.allen.whitehorsestock.entity.LoginEntity
import io.reactivex.Observable
import me.goldze.mvvmhabit.http.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface LoginApiService {
    @GET("action/apiv2/banner?catalog=1")
    fun demoGet(): Observable<BaseResponse<LoginEntity?>?>?

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    fun demoPost(@Field("catalog") catalog: String?): Observable<BaseResponse<LoginEntity?>?>?
}