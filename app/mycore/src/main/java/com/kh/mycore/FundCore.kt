package com.kh.mycore

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.kh.mycore.BuildConfig
import com.orhanobut.hawk.Hawk
import com.kh.mycore.data.database.Database
import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.network.ApiService
import com.kh.mycore.data.network.interceptor.RequestHeaderInterceptor
import com.kh.mycore.data.network.interceptor.ResponseBodyInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object FundCore {

    internal lateinit var applicationContext: Context
    internal val apiService by lazy { provideApi(provideRetrofit(provideInterceptors())) }
    internal lateinit var dataBase: Database

    fun init(application: Context) {
        applicationContext = application.applicationContext
        // apiService= provideApi(provideRetrofit(provideInterceptors()))
        dataBase = provideDatabase(application.applicationContext)
        Hawk.init(applicationContext).build()
    }


    //internal fun getContext(): Context = applicationContext
    //internal fun getDataBase(): Database = dataBase

    private fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java
    )


    private fun provideInterceptors(): ArrayList<Interceptor> {

        val interceptors = arrayListOf<Interceptor>()
        interceptors.add(RequestHeaderInterceptor())
        interceptors.add(ResponseBodyInterceptor())
        return interceptors
    }


    private fun provideRetrofit(interceptors: ArrayList<Interceptor>): Retrofit {

        val clientBuilder = OkHttpClient.Builder()
        if (interceptors.isNotEmpty()) {
            interceptors.forEach { interceptor ->
                clientBuilder.addInterceptor(interceptor)
            }
        }
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            clientBuilder.addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .client(clientBuilder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .baseUrl(ApiService.BASE_URL)
            .build()
    }

    private fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        Database::class.java,
        "rayan-fund-db"
    )
        .allowMainThreadQueries()
        .build()


    private fun provideGson() =
        GsonBuilder()
            .setLenient()
            .create()




    internal fun <T> getEntityDao(entityName: String?): T {
        return when (entityName) {
            BranchData::class.simpleName -> dataBase.branchDataDao()
            else -> null
        } as T
    }


}