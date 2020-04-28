package com.kh.mycore.service

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

abstract class CoreService {

    companion object{
        val errorPublisher: PublishSubject<ServiceResult<Unit>> =PublishSubject.create()
    }

    protected fun <T> convertToObservable (processor: ReplaySubject<T>, disposable: Disposable): Observable<T> {
        return processor.toFlowable(BackpressureStrategy.BUFFER).toObservable().doFinally{
            disposable.dispose()
        }
    }

}