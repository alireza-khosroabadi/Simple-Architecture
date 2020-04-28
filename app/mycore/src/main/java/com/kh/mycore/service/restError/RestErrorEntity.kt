package com.kh.mycore.service.restError

data class RestErrorEntity(
    val title: String,
    val description: String = "",
    val descriptionEn: String = "",
    val errorType: String = "",
    val UUID: String = "",
    val errorCode: Int = 0,
    val requestType: Int = 0
)