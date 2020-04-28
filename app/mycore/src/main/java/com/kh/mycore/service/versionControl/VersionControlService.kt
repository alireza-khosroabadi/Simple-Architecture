package com.kh.mycore.service.versionControl

import com.kh.mycore.service.CoreService
import com.kh.mycore.service.ServiceResult
import com.kh.mycore.service.versionControl.entities.LastVersionEntity
import com.kh.mycore.service.versionControl.entities.ReleaseNoteEntity
import io.reactivex.Observable

abstract class VersionControlService : CoreService() {

    abstract fun checkApplicationVersion(): Observable<ServiceResult<LastVersionEntity>>
    abstract fun needApplicationToUpdate(): Boolean
    abstract fun updateAvailable(): Boolean
    abstract fun listReleaseNotes(): Observable<ServiceResult<List<ReleaseNoteEntity>>>
    abstract fun serverDate()
    abstract fun currentDate():String
    abstract fun applicationLastVersion():LastVersionEntity?
    abstract fun applicationVersionName():String
}