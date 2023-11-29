package com.android.authenticationapp.data.network

import com.android.authenticationapp.data.model.payment.ListData
import com.android.authenticationapp.data.model.token.LoginRequest
import com.android.authenticationapp.data.model.token.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("app-key: 12345", "v: 1")
    @POST("login")
    suspend fun getToken(@Body loginRequest: LoginRequest): Response<TokenResponse>

    @Headers("app-key: 12345", "v: 1")
    @GET("payments")
    suspend fun getList(@Header("token") token: String): ListData


}