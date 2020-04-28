package com.kh.mycore.data.network.entities.error

import com.google.gson.annotations.SerializedName
import com.kh.mycore.data.network.entities.Dto

const val ERROR_CODE_INVALID_TOKEN = 10004
const val ERROR_CODE_WRONG_USER_PASS = 10100

const val ERROR_CODE_INVALID_CODE = 10051
const val ERROR_CODE_INVALID_USER_NAME = 10015
const val ERROR_CODE_INVALID_NATIONAL_CODE = 10048
const val ERROR_CODE_INVALID_NATIONAL_CODE_ = 10049
const val ERROR_CODE_INVALID_LATIN_USER_NAME = 10016
const val ERROR_CODE_UPLOAD_FILES = 10025
const val ERROR_CODE_IMAGE_SIZE = 10024
const val ERROR_CODE_FORMAT_FILE = 10026
const val ERROR_CODE_NATIONAL_CODE = 10047
const val ERROR_CODE_LANGUAGE_NOT_SUPPORT = 10050
const val ERROR_CODE_REPETITIOUS_CUSTOMER = 10080
const val ERROR_CODE_LICENCE_NOT_FOUND = 30001
const val ERROR_CODE_EPAYMENT_PRICE = 30080
const val ERROR_CODE_FORGET_PASSWORD_WRONG_DATA = 30081

const val ERROR_TYPE_INVALID_TOKEN = "com.rh.ot.web.core.BusinessException"
const val ERROR_TYPE_NULL_POINTER_EXCEPTION = "java.lang.NullPointerException"
const val ERROR_TYPE_WRONG_CAPTCHA = "401"
const val ERROR_TYPE_EMPTY_CAPTCHA = "404"
const val ERROR_TYPE_WRONG_USER_PASS = "403"

const val ERROR_DESCRIPTION_SYSTEM_ERROR = "بروز خطا در سیستم ;An error occurred"
const val ERROR_DESCRIPTION_INVALID_TOKEN =
    "توکن امنیتی معتبر نمی باشد. مجددا لاگین کنید ;Security token is not valid...please login again"
const val ERROR_DESCRIPTION_NO_TOKEN =
    "توکن امنیتی در درخواست یافت نشد ;Security token not found"
const val ERROR_DESCRIPTION_ERROR_UUID_PREFIX = "ERROR LOGGED WITH THIS UUID"

const val RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500
const val RESPONSE_CODE_UNAUTHORIZED = 401
const val RESPONSE_CODE_FORBIDDEN = 403
const val RESPONSE_CODE_NOT_FOUND = 404
const val MOBILE_NOT_VALID_FOR_USER = 406

const val REQUEST_TYPE_LOGIN = 1

data class RestError(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String = "",
    @SerializedName("descriptionEn") val descriptionEn: String = "",
    @SerializedName("errorType")  val errorType: String = "",
    @SerializedName("UUID")  val UUID: String = "",
    @SerializedName("errorCode") val errorCode: Int = 0,
    @SerializedName("requestType") val requestType: Int = 0
):Dto