package com.example.parcialtp3.data.remote

import com.example.parcialtp3.data.remote.model.*

class AuthRepositoryImpl(
    private val api: ApiService
) : AuthRepository {

    override suspend fun login(username: String, password: String): LoginResponse {
        return api.login(LoginRequest(username = username, password = password))
    }

    override suspend fun createAccount(
        fullName: String,
        email: String,
        phone: String,
        password: String
    ): CreateAccountResponse {
        val parts = fullName.trim().split(" ")
        val first = parts.firstOrNull().orEmpty()
        val last = parts.drop(1).joinToString(" ")
        val username = email.substringBefore("@")
        val body = CreateAccountRequest(
            email = email,
            username = username.ifBlank { email },
            password = password,
            name = CreateAccountRequest.Name(firstname = first, lastname = last),
            phone = phone
        )
        return api.createAccount(body)
    }
}