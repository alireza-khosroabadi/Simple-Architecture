package com.kh.mycore.service.versionControl

import android.os.Build
import androidx.core.content.pm.PackageInfoCompat
import com.kh.mycore.FundCore
import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import com.kh.mycore.data.network.entities.nowDate.ServerDateDto
import kotlin.properties.Delegates

internal object VersionControlServiceDataHolder {
    var updateAvailable = false

    //    var releaseNotes: ReleaseNotes? = null
    var currentDate: ServerDateDto? = ServerDateDto("","")
    var lastVersion: LastVersionDto? by Delegates.observable<LastVersionDto?>(null) { _, _, new ->
        updateAvailable = new?.let {
            PackageInfoCompat.getLongVersionCode(
                FundCore.applicationContext.packageManager
                    .getPackageInfo(
                        FundCore.applicationContext.packageName,
                        0
                    )
            ).toInt() < it.versionCode
        } ?: false
    }


}