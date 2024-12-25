package com.example.loveapp

import com.example.loveapp.data.local.ResultDao
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.data.network.ApiService
import javax.inject.Inject
import retrofit2.Response

class LoveRepository @Inject constructor(
    private val api: ApiService,
    private val dao: ResultDao
) {

    suspend fun fetchAndSaveLoveResult(firstName: String, secondName: String, percentage: String, result: String) {
        try {
            val response = api.getPercentage(firstName, secondName, percentage, result)
            if (response.isSuccessful) {
                val result = response.body()!!
                result?.let {
                    val transformedResult = LoveModel(
                        firstName = firstName,
                        secondName = secondName,
                        percentage = percentage,
                        result = result
                    )
                    dao.insertNote(transformedResult)
                }
            } else {
                throw Exception("API call failed with code: ${response.code} and message: ${response.message()}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}