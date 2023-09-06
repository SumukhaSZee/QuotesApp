package com.example.quotesapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.api.RetrofitInstance
import com.example.quotesapp.models.QuoteResponse
import com.example.quotesapp.models.QuoteResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel :ViewModel() {

    val quotesList = MutableLiveData<ArrayList<QuoteResponseItem>?>()
    fun fetchQuotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = RetrofitInstance.api.getQuotes()

            if (result.isSuccessful) {
                val quotesResponse = result.body()
                if (quotesResponse != null) {
                    quotesList.postValue(quotesResponse)
                }
            }
        }
    }
}

