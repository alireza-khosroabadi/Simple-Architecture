package com.kh.mycore.service.branch

import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.extentions.map
import com.kh.mycore.data.network.entities.Status
import com.kh.mycore.service.ServiceResult
import com.kh.mycore.data.repository.branch.BranchRepositoryImp
import com.kh.mycore.service.ConfigStateHolder
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject

class BranchServiceImpl : BranchService() {

    private val branchRepository = BranchRepositoryImp()

    override fun loadBranches(): Observable<ServiceResult<List<BranchEntity>>> {
        val processor: ReplaySubject<ServiceResult<List<BranchEntity>>> = ReplaySubject.create()

        val disposable = branchRepository.loadBranchList(ConfigStateHolder.isTestServer)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when (it.status) {
                    Status.SUCCESS -> processor.onNext(ServiceResult.Success(it.data?.map { it.map() }?: emptyList()))
                    Status.REST_ERROR -> processor.onNext(ServiceResult.ServerError(it.restError))
                }
            }, {
                processor.onNext(ServiceResult.Error(it))
                it.printStackTrace()
            })
        processor.onNext(
            ServiceResult.Loading(null)
        )
        return convertToObservable(processor, disposable)
    }

    override fun getBranchList(): Observable<ServiceResult<List<BranchEntity>>> {
        val processor: ReplaySubject<ServiceResult<List<BranchEntity>>> = ReplaySubject.create()
        val disposable = branchRepository.loadLocalBranchesList()
            .subscribeOn(Schedulers.io())
            .subscribe({
                processor.onNext(ServiceResult.Success(it.map { it.map() }))
            }, {
                processor.onNext(ServiceResult.Error(it))
                it.printStackTrace()
            })
        processor.onNext(ServiceResult.Loading(null))
        //addDisposable(disposable)
        return convertToObservable(processor, disposable)
    }

    override fun getCurrentBranch(): BranchEntity? = BranchServiceDataHolder.currentBranch?.map()

    override fun setCurrentBranch(currentBranch: BranchEntity) {
        BranchServiceDataHolder.currentBranch = currentBranch.map()
    }
}