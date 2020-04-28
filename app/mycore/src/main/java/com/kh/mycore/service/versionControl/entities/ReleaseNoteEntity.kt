package com.kh.mycore.service.versionControl.entities

data class ReleaseNoteEntity(
    var versionCode: Int,
    val versionName: String,
    val versionDate: String,
    val note: String?
)