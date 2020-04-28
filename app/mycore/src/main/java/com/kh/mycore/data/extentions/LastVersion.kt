package com.kh.mycore.data.extentions

import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import com.kh.mycore.service.versionControl.entities.LastVersionEntity

/**
 * Extensions function to convert [LastVersionDto] to [LastVersionEntity]
 *
 */
internal fun LastVersionDto.map() =
    LastVersionEntity(
        versionCode,
        forceUpdate,
        versionName,
        directLink
    )