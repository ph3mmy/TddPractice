package com.oluwafemi.tddpractice.api_service

object ApiUtils {

    private var apiService: PostService? = null

    fun getApiService(): PostService? {

        if (apiService == null) {
            apiService = RetrofitClient.client!!.create(PostService::class.java)
        }
        return apiService
    }
}
