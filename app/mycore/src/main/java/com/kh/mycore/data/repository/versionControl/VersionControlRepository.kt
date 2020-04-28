package com.kh.mycore.data.repository.versionControl

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import io.reactivex.Single

internal interface VersionControlRepository {

    fun checkApplicationVersion(): Single<BaseResponse<LastVersionDto>>
}