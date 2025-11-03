package com.example.parcialtp3.data.remote

import com.example.parcialtp3.data.remote.model.*

interface AuthRepository {
    suspend fun login(username: String, password: String): LoginResponse
    suspend fun createAccount(
        fullName: String,
        email: String,
        phone: String,
        password: String
    ): CreateAccountResponse
}