package com.sanguyen.android.cryptocurrencyapp.domain.repository

import com.sanguyen.android.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.sanguyen.android.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}