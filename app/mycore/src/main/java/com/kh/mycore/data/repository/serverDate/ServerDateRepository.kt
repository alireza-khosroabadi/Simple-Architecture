package com.kh.mycore.data.repository.serverDate

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.nowDate.ServerDateDto
import io.reactivex.Single

internal interface ServerDateRepository {

    fun serverDate(): Single<BaseResponse<ServerDateDto>>
}