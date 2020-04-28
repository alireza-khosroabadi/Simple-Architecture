package com.kh.mycore.data.repository.releaseNote

import com.kh.mycore.BuildConfig
import com.kh.mycore.FundCore
import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.releaseNote.ReleaseNoteDto
import com.kh.mycore.service.ConfigStateHolder
import io.reactivex.Single

class ReleaseNotRepositoryImp : ReleaseNoteRepository {
    override fun getReleaseNote(): Single<BaseResponse<List<ReleaseNoteDto>>> =
        FundCore.apiService.releaseNotes(BuildConfig.VERSION_CODE, ConfigStateHolder.isTestServer)
}