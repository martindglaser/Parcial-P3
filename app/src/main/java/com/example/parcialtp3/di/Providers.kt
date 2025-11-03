package com.example.parcialtp3.di

import com.example.parcialtp3.data.remote.AuthRepository
import com.example.parcialtp3.data.remote.AuthRepositoryImpl
import com.example.parcialtp3.data.remote.RetrofitClient

object Providers {
    val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(RetrofitClient.api)
    }
}