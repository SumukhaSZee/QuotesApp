package com.example.quotesapp

import com.example.quotesapp.api.ApiInterface
import com.example.quotesapp.repository.quoterepository
import com.example.quotesapp.repository.quoterepositoryinterface
import com.example.quotesapp.utils.constants.BASE_URL
import com.example.quotesapp.viewmodel.QuotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appmodule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())     // For ApiInstance
            .build()
            .create(ApiInterface::class.java)

    }
    single <quoterepositoryinterface>{
           quoterepository(get( ))                                                          // For Repository
    }
    viewModel{
        QuotesViewModel(get())
    }
}