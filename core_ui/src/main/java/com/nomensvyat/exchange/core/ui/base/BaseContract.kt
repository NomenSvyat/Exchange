package com.nomensvyat.exchange.core.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.nomensvyat.exchange.core.utils.extensions.*
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

interface BaseView : MvpView

abstract class BasePresenter<T : BaseView> : MvpPresenter<T>() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    private val localDefaultOnError: OnError = { Timber.e(it) }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    protected fun Disposable.bind(): Disposable = apply {
        disposables.add(this)
    }

    //region Extensions
    protected fun Completable.subscribeAndBind(
        onComplete: OnComplete = defaultOnComplete,
        onError: OnError = localDefaultOnError
    ): Disposable =
        observeOn(AndroidSchedulers.mainThread())
            .safeSubscribe(onComplete, onError)
            .bind()

    protected fun <T> Observable<T>.subscribeAndBind(
        onNext: OnNext<T> = {},
        onError: OnError = localDefaultOnError,
        onComplete: OnComplete = defaultOnComplete
    ): Disposable =
        observeOn(AndroidSchedulers.mainThread())
            .safeSubscribe(onNext, onError, onComplete)
            .bind()

    protected fun <T> Flowable<T>.subscribeAndBind(
        onNext: OnNext<T> = {},
        onError: OnError = localDefaultOnError,
        onComplete: OnComplete = defaultOnComplete
    ): Disposable =
        observeOn(AndroidSchedulers.mainThread())
            .safeSubscribe(onNext, onError, onComplete)
            .bind()

    protected fun <T> Single<T>.subscribeAndBind(
        onSuccess: OnSuccess<T> = {},
        onError: OnError = localDefaultOnError
    ): Disposable =
        observeOn(AndroidSchedulers.mainThread())
            .safeSubscribe(onSuccess, onError)
            .bind()

    protected fun <T> Maybe<T>.subscribeAndBind(
        onSuccess: OnSuccess<T> = {},
        onError: OnError = localDefaultOnError,
        onComplete: OnComplete = defaultOnComplete
    ): Disposable =
        observeOn(AndroidSchedulers.mainThread())
            .safeSubscribe(onSuccess, onError, onComplete)
            .bind()

    //endregion
}

