package com.example.parcialtp3.data.remote

import com.example.parcialtp3.data.remote.model.*
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("x-api-key: 123456789")
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @Headers("x-api-key: 123456789")
    @POST("auth/create")
    suspend fun createAccount(@Body body: CreateAccountRequest): CreateAccountResponse
}