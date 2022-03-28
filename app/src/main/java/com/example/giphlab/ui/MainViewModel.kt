package com.example.giphlab.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.giphlab.data.remote.Resource
import com.example.giphlab.domain.GiphLabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GiphLabRepository
) : ViewModel() {

    fun getTrends() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repository.getTrending())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}