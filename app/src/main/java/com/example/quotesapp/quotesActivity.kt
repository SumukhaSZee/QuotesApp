package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.quotesapp.viewmodel.QuotesViewModel

class quotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // Associate with the navigation graph
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_graph)
        navController.graph = graph

        // Navigate to the starting fragment
        navController.navigate(R.id.welcomeFragment)
    }


    }
