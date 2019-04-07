package com.oluwafemi.tddpractice.api_service

object ApiUtils {

    private var apiService: ApiService? = null

    fun getApiService(): ApiService? {

        if (apiService == null) {
            apiService = RetrofitClient.client!!.create(ApiService::class.java)
        }
        return apiService
    }
}
