package com.example.quotesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.adapter.QuoteAdapter
import com.example.quotesapp.databinding.FragmentQuoteListBinding
import com.example.quotesapp.databinding.FragmentWelcomeBinding
import com.example.quotesapp.models.QuoteResponseItem
import com.example.quotesapp.viewmodel.QuotesViewModel

class QuoteListFragment : Fragment() {

    private lateinit var binding: FragmentQuoteListBinding
    lateinit var viewModel : QuotesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuoteListBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[QuotesViewModel::class.java]
        viewModel.fetchQuotes()
        viewModel.quotesList.observe(viewLifecycleOwner, Observer {

            if(it!= null){
                prepareRecyclerView(it)
            }

        })

    }

    private fun prepareRecyclerView(response: ArrayList<QuoteResponseItem>?) {
        val recycleView = view?.findViewById<RecyclerView>(R.id.recyclerview)
        recycleView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,true)
        val recycleAdapter = response?.let { QuoteAdapter(it) }
        recycleView?.adapter = recycleAdapter

    }


}