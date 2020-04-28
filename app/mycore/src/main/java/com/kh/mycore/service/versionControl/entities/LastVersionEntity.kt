package com.kh.mycore.service.versionControl.entities

data class LastVersionEntity(
    val versionCode: Int,
    val forceUpdate: Boolean,
    val versionName: String?,
    val directLink: String?
)