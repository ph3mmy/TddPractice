package com.oluwafemi.tddpractice.api_service

import android.util.Log
import com.oluwafemi.tddpractice.utility.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }


    private fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                //                Request.Builder requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                //                        .header("X-Requested-With", UrlConstants.REQUEST_WITH)
                .method(original.method(), original.body())
                .build()

            Log.e("RETROFIT-CLIENT", "intercept: url == " + original.url() + " body == " + original.body())
            chain.proceed(request)
        }

        return okhttpClientBuilder.build()
    }
}
