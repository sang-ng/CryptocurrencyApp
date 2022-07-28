package com.sanguyen.android.cryptocurrencyapp.domain.use_case.get_coin

import com.sanguyen.android.cryptocurrencyapp.common.Resource
import com.sanguyen.android.cryptocurrencyapp.data.remote.dto.toCoin
import com.sanguyen.android.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.sanguyen.android.cryptocurrencyapp.domain.model.Coin
import com.sanguyen.android.cryptocurrencyapp.domain.model.CoinDetail
import com.sanguyen.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}