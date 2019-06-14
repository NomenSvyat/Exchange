package com.nomensvyat.exchange.network.di

import com.nomensvyat.exchange.core.domain.config.AppConfig
import com.nomensvyat.exchange.network.api.CurrencyApi
import com.nomensvyat.exchange.network.utils.parsing.TikXmlFactory
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
        okHttpClient: OkHttpClient,
        tikXmlFactory: TikXmlFactory
    ): Retrofit.Builder =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(TikXmlConverterFactory.create(tikXmlFactory.tiXml))

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