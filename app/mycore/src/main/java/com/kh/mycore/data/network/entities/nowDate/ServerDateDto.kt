package com.kh.mycore.data.network.entities.nowDate

import com.google.gson.annotations.SerializedName
import com.kh.mycore.data.network.entities.Dto

data class ServerDateDto(
    @SerializedName("todayJalali") val todayJalaly: String?,
    @SerializedName("todayGregorian") val todayGregorian: String?
):Dto