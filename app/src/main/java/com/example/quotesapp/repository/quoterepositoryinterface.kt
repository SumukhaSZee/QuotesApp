package com.example.quotesapp.repository

import com.example.quotesapp.models.QuoteResponse
import retrofit2.Response

interface quoterepositoryinterface  {
    suspend fun getQuotes() : Response<QuoteResponse>
}