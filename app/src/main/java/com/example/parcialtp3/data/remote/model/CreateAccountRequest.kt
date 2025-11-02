package com.example.parcialtp3.data.remote.model

data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String,
    val name: Name,
    val phone: String
) {
    data class Name(val firstname: String, val lastname: String)
}