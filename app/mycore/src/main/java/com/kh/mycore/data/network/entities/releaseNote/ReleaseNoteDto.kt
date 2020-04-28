package com.kh.mycore.data.network.entities.releaseNote

import com.kh.mycore.data.network.entities.Dto

data class ReleaseNoteDto(
    var versionCode: Int,
    val versionName: String,
    val versionDate: String,
    val note: String?
) : Dto