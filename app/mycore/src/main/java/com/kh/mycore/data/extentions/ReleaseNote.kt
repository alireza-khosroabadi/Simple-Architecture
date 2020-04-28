package com.kh.mycore.data.extentions

import com.kh.mycore.data.network.entities.releaseNote.ReleaseNoteDto
import com.kh.mycore.service.versionControl.entities.ReleaseNoteEntity

/**
 * Extensions function to convert [ReleaseNoteDto] to [ReleaseNoteEntity]
 *
 */
internal fun ReleaseNoteDto.map() : ReleaseNoteEntity =
    ReleaseNoteEntity(versionCode, versionName, versionDate, note)