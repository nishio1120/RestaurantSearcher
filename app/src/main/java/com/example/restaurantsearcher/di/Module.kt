package com.example.restaurantsearcher.di

import android.content.Context
import com.example.restaurantsearcher.R
import com.example.restaurantsearcher.ui.model.HotPepperService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

//複数のバインディングの定義をグループ化する
@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideRetrofit(@ApplicationContext context: Context, moshi: Moshi, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(context.getString(R.string.hot_pepper_url))
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()

    @Provides
    fun provideHotPepperService(retrofit: Retrofit): HotPepperService =
        retrofit.create(HotPepperService::class.java)
}