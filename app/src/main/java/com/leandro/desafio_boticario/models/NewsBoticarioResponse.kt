package com.leandro.desafio_boticario.models

import com.google.gson.annotations.SerializedName

class NewsBoticarioResponse (
    @SerializedName("news") val news: ArrayList<NewsBoticario>
)