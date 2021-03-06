package com.kh.mycore.data.network.api.verionControlApi

import com.kh.mycore.data.network.ApiService
import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import io.reactivex.Single

internal class CheckVersionApiImp:CheckVersionApi {
    override fun checkClientVersion(apiService: ApiService): Single<BaseResponse<LastVersionDto>> =apiService.getLastClientVersion("android")
}