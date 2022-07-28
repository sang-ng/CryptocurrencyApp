package com.sanguyen.android.cryptocurrencyapp.data.remote

import com.sanguyen.android.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins()

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto
}