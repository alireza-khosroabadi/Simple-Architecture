package com.kh.mycore.service.versionControl

import com.kh.mycore.FundCore
import com.kh.mycore.data.extentions.map
import com.kh.mycore.data.network.entities.Status
import com.kh.mycore.data.repository.releaseNote.ReleaseNotRepositoryImp
import com.kh.mycore.data.repository.releaseNote.ReleaseNoteRepository
import com.kh.mycore.data.repository.serverDate.ServerDateRepositoryImp
import com.kh.mycore.data.repository.versionControl.VersionControlRepositoryImp
import com.kh.mycore.service.ServiceResult
import com.kh.mycore.service.versionControl.entities.LastVersionEntity
import com.kh.mycore.service.versionControl.entities.ReleaseNoteEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject


class VersionControlServiceImp : VersionControlService() {
    override fun checkApplicationVersion(): Observable<ServiceResult<LastVersionEntity>> {
        val processor: ReplaySubject<ServiceResult<LastVersionEntity>> = ReplaySubject.create()
        val versionControlRepository = VersionControlRepositoryImp()
        val disposable = versionControlRepository.checkApplicationVersion()
            .subscribe({
                when (it.status) {
                    Status.SUCCESS -> {
                        VersionControlServiceDataHolder.lastVersion = it.data
                        it.data?.let { processor.onNext(ServiceResult.Success(it.map())) }
                    }
                    Status.REST_ERROR -> processor.onNext(ServiceResult.ServerError(it.restError))
                    Status.NETWORK_ERROR -> processor.onNext(ServiceResult.Error(it.throwable!!))
                }
            }, {
                processor.onNext(ServiceResult.Error(it))
            })
        //addDisposable(disposable)
        processor.onNext(ServiceResult.Loading(null))
        return convertToObservable(processor, disposable)
    }

    override fun needApplicationToUpdate(): Boolean =
        VersionControlServiceDataHolder.lastVersion?.forceUpdate ?: false

    override fun updateAvailable(): Boolean = VersionControlServiceDataHolder.updateAvailable
    override fun listReleaseNotes(): Observable<ServiceResult<List<ReleaseNoteEntity>>> {
        val processor = ReplaySubject.create<ServiceResult<List<ReleaseNoteEntity>>>()
        val releaseNoteRepository = ReleaseNotRepositoryImp();
        val disposable = releaseNoteRepository.getReleaseNote()
            .subscribe({
                when (it.status) {
                    Status.SUCCESS -> it?.data?.let { processor.onNext(ServiceResult.Success(it.map { it.map() })) }
                    Status.REST_ERROR -> processor.onNext(ServiceResult.ServerError(it.restError))
                    Status.NETWORK_ERROR -> processor.onNext(ServiceResult.Error(it.throwable!!))
                }
            }, {
                processor.onNext(ServiceResult.Error(it))
            })
        //addDisposable(disposable)
        processor.onNext(ServiceResult.Loading(null))
        return convertToObservable(processor,disposable)
    }

    override fun serverDate() {
        val disposable = ServerDateRepositoryImp().serverDate()
            .subscribe({
                when (it.status) {
                    Status.SUCCESS -> it.data?.let {
                        VersionControlServiceDataHolder.currentDate = it
                    }
                }
            }, {
                it.printStackTrace()
            }).dispose()
    }

    override fun currentDate(): String {
        return if (VersionControlServiceDataHolder.currentDate != null
            && VersionControlServiceDataHolder.currentDate?.todayJalaly != null) {
            VersionControlServiceDataHolder.currentDate?.todayJalaly!!
        } else {
            serverDate()
            String()
            // TODO most change with Tools Utility.getNowDateShamsi() method
        }
    }

    override fun applicationLastVersion(): LastVersionEntity? =
        VersionControlServiceDataHolder.lastVersion?.map()

    override fun applicationVersionName(): String =
        FundCore.applicationContext.packageManager.getPackageInfo(
            FundCore.applicationContext.packageName,
            0
        ).versionName
}