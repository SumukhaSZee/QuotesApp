package com.example.quotesapp.api

import com.example.quotesapp.models.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("quotes")
    suspend fun getQuotes() : Response<QuoteResponse>


}