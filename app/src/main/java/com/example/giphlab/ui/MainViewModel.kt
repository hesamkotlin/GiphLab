package com.example.giphlab.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphlab.data.remote.Resource
import com.example.giphlab.domain.GiphLabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GiphLabRepository
) : ViewModel() {

    fun getTrends() {
        viewModelScope.launch {
            val result = repository.getTrending()

            when (result) {
                is Resource.Loading -> {
                    // ToDo
                }
                is Resource.Success -> {
                    Log.d("hesam", "the request has been successful")
                }
                is Resource.Failure -> {
                    // ToDo
                }
            }
        }
    }
}