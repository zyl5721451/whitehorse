package com.allen.whitehorsestock.data.source

import com.allen.whitehorsestock.entity.LoginEntity
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import me.goldze.mvvmhabit.http.BaseResponse
import java.util.concurrent.TimeUnit


class LoginHttpDataSourceImpl :LoginHttpDataSource{
    private var apiService: LoginApiService? = null

    @Volatile
    private var INSTANCE: LoginHttpDataSourceImpl? = null

    constructor(apiService: LoginApiService?) {
        this.apiService = apiService
    }

    fun getInstance(apiService: LoginApiService): LoginHttpDataSourceImpl? {
        if (INSTANCE == null) {
            synchronized(LoginHttpDataSourceImpl::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = LoginHttpDataSourceImpl(apiService)
                }
            }
        }
        return INSTANCE
    }


    fun destroyInstance() {
        INSTANCE = null
    }


    override fun login(): Observable<Any?>? {
        return Observable.just(Any())
            .delay(3, TimeUnit.SECONDS) //延迟3秒
    }

    override fun loadMore(): Observable<LoginEntity?>? {
        return Observable.create(object : ObservableOnSubscribe<LoginEntity?> {
            @Throws(Exception::class)
            override fun subscribe(observableEmitter: ObservableEmitter<LoginEntity?>) {
                val entity = LoginEntity()
                val itemsEntities: MutableList<LoginEntity.ItemsEntity> = ArrayList()
                //模拟一部分假数据
                for (i in 0..9) {
                    val item = LoginEntity.ItemsEntity()
                    item.id = -1
                    item.name = "模拟条目"
                    itemsEntities.add(item)
                }
                entity.setItems(itemsEntities)
                observableEmitter.onNext(entity)
            }
        }).delay(3, TimeUnit.SECONDS) //延迟3秒
    }

    override fun demoGet(): Observable<BaseResponse<LoginEntity?>?>? {
        return apiService?.demoGet()
    }

    override fun demoPost(catalog: String?): Observable<BaseResponse<LoginEntity?>?>? {
        return apiService?.demoPost(catalog)
    }

}