package com.example.giphlab.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphlab.data.model.GiphLab
import com.example.giphlab.data.remote.Resource
import com.example.giphlab.domain.GiphLabRepository
import com.example.giphlab.shared.model.GifModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GiphLabRepository
) : ViewModel() {

    private val mGifs = MutableLiveData<List<GifModel>?>()
    val gifs: LiveData<List<GifModel>?> = mGifs

    private val mLoading = MutableLiveData(false)
    val loading: LiveData<Boolean> = mLoading

    fun getTrends() {
        viewModelScope.launch(Dispatchers.IO) {
            mLoading.postValue(true)
            when (val result = repository.getTrending()) {
                is Resource.Loading -> {
                    Log.d("hesam", "Loading")
                }
                is Resource.Success -> {
                    mLoading.postValue(false)
                    Log.d("hesam", "the request has been successful")
                    Log.d("hesam", result.data.toString())
                    mGifs.postValue(result.data)
                }
                is Resource.Failure -> {
                    Log.d("hesam", "Failure")
                }
            }
        }
    }
}