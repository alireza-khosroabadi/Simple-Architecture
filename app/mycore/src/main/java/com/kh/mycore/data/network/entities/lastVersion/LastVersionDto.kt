package com.kh.mycore.data.network.entities.lastVersion

import com.google.gson.annotations.SerializedName
import com.kh.mycore.data.network.entities.Dto

data class LastVersionDto(
    @SerializedName("versionCode") val versionCode:Int,
    @SerializedName("forceUpdate") val forceUpdate:Boolean,
    @SerializedName("versionName") val versionName:String,
    @SerializedName("directLink") val directLink:String
):Dto