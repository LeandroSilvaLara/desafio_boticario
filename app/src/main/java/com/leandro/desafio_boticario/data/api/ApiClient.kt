package com.leandro.desafio_boticario.data.api

import com.leandro.desafio_boticario.service.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    @JvmStatic
    fun getClient(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val builder = Retrofit.Builder()
        builder.baseUrl(Constants.BASE_URL)
        builder.addConverterFactory(GsonConverterFactory.create())
        builder.client(httpClient.build())
        return builder.build()
    }
}