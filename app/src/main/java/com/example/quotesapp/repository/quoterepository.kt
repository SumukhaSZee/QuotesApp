package com.example.quotesapp.repository

import com.example.quotesapp.api.RetrofitInstance

class quoterepository() {
    suspend fun getQuotes() =
        RetrofitInstance.api.getQuotes()
}