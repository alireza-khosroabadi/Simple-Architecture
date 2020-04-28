package com.kh.mycore.data.repository.serverDate

import com.kh.mycore.FundCore
import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.nowDate.ServerDateDto
import io.reactivex.Single

internal class ServerDateRepositoryImp :ServerDateRepository{

    /**
     * get Server Date to Sync with Application
     *
     * @return
     */
    override fun serverDate(): Single<BaseResponse<ServerDateDto>> = FundCore.apiService.getNowDate()

}