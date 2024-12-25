package com.example.loveapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loveapp.App
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveViewModel : ViewModel() {

    private val _loveResult = MutableLiveData<LoveModel?>()
    val loveResult: LiveData<LoveModel?> get() = _loveResult

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    var loadingProgressBar = MutableLiveData<Boolean>()

    fun getPercentage(firstName: String, secondName: String) {

        _loveResult.value = null
        loadingProgressBar.value = true
        RetrofitInstance.api.getPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "9ab403d45bmsh5e7a6133bc1029dp102882jsnd6462fe926c0",
            host = "https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John"
        ).enqueue(object : Callback<LoveModel> {

            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {

                if (response.isSuccessful && response.body() != null) {
                    App.appDatabase?.resultDao()?.insertNote(response.body()!!)
                    _loveResult.value = response.body()
                    loadingProgressBar.value = false
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                _error.value = t.message.toString()
            }
        })
    }
}