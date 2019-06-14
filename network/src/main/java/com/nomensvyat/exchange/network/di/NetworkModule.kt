package com.nomensvyat.exchange.network.di

import com.nomensvyat.exchange.core.domain.config.AppConfig
import com.nomensvyat.exchange.network.api.CurrencyApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideOkHttp(
        @Named(LOGGING_INTERCEPTOR) loggingInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Named(LOGGING_INTERCEPTOR)
    @Provides
    fun provideLoggingInterceptor(appConfig: AppConfig): Interceptor {
        val level = if (appConfig.isLoggingEnabled) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        return HttpLoggingInterceptor().setLevel(level)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit.Builder =
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(SimpleXmlConverterFactory.create())

    @Provides
    fun provideCurrencyApi(retrofitBuilder: Retrofit.Builder): CurrencyApi =
        retrofitBuilder
            .baseUrl(CurrencyApi.BASE_URL)
            .build()
            .create(CurrencyApi::class.java)

    private companion object {
        private const val LOGGING_INTERCEPTOR = "logging"
    }
}