package com.leandro.desafio_boticario.data.api

import com.leandro.desafio_boticario.models.NewsBoticarioResponse
import com.leandro.desafio_boticario.service.Constants
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(Constants.URL_GET_NEWS)
    fun getNewsBoticario(): Call<NewsBoticarioResponse>
}