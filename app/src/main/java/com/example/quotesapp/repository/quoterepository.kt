package com.example.quotesapp.repository

import com.example.quotesapp.api.ApiInterface

class quoterepository(
    private val apiInterface: ApiInterface
):quoterepositoryinterface {
    override suspend fun getQuotes() =
        apiInterface.getQuotes()
}