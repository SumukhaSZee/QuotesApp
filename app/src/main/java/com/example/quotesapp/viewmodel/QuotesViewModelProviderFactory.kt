package com.example.quotesapp.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.repository.quoterepository


class QuotesViewModelProviderFactory(
    val quoterepository: quoterepository
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoterepository) as T
    }
}



