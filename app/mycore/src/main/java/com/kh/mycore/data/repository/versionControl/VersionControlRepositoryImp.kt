package com.kh.mycore.data.repository.versionControl

import com.kh.mycore.FundCore
import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import io.reactivex.Single

class VersionControlRepositoryImp:VersionControlRepository {

    /**
     * load Application last version release information
     *
     * @return
     */
    override fun checkApplicationVersion(): Single<BaseResponse<LastVersionDto>> {
        return FundCore.apiService.getLastClientVersion("android")
    }
}