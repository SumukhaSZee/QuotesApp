package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.models.QuoteResponseItem
import com.example.quotesapp.repository.quoterepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuotesViewModel(
    val quoterepository: quoterepository
    ) :ViewModel() {


    private val _quotesList = MutableStateFlow<List<QuoteResponseItem>?>(null)
    val quotesList: StateFlow<List<QuoteResponseItem>?> = _quotesList

    init {
        fetchQuotes()
    }
    fun fetchQuotes() {
        viewModelScope.launch(Dispatchers.IO) {
           /* val result = RetrofitInstance.api.getQuotes()*/
            val result = quoterepository.getQuotes()

            if (result.isSuccessful) {
                val quotesResponse = result.body()
                if (quotesResponse != null) {
                    _quotesList.value = quotesResponse
                }
            }
        }
    }
}

