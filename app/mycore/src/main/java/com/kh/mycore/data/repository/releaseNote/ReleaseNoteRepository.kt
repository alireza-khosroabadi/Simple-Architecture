package com.kh.mycore.data.repository.releaseNote

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.releaseNote.ReleaseNoteDto
import io.reactivex.Single

internal interface ReleaseNoteRepository {

    /**
     * load Application Release notes from Server
     *
     * @return
     */
    fun getReleaseNote(): Single<BaseResponse<List<ReleaseNoteDto>>>
}