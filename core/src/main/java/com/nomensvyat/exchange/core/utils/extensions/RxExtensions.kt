package com.nomensvyat.exchange.core.utils.extensions

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

//region DoAndWait
inline fun <T> Maybe<T>.doAndWait(crossinline completableAction: (T) -> Completable): Maybe<T> =
    flatMap {
        completableAction(it)
            .andThen(Maybe.just(it))
    }

inline fun <T> Single<T>.doAndWait(crossinline completableAction: (T) -> Completable): Single<T> =
    flatMap {
        completableAction(it)
            .andThen(Single.just(it))
    }
//endregion

typealias OnError = (Throwable) -> Unit
typealias OnNext<T> = (T) -> Unit
typealias OnSuccess<T> = (T) -> Unit
typealias OnComplete = () -> Unit

val defaultOnComplete: OnComplete = {}
val defaultOnError: OnError = { Timber.e(it) }

//region SafeSubscribe
fun Completable.safeSubscribe(
    onComplete: OnComplete = defaultOnComplete,
    onError: OnError = defaultOnError
): Disposable = subscribe(onComplete, onError)

fun <T> Observable<T>.safeSubscribe(
    onNext: OnNext<T> = {},
    onError: OnError = defaultOnError,
    onComplete: OnComplete = defaultOnComplete
): Disposable = subscribe(onNext, onError, onComplete)

fun <T> Flowable<T>.safeSubscribe(
    onNext: OnNext<T> = {},
    onError: OnError = defaultOnError,
    onComplete: OnComplete = defaultOnComplete
): Disposable = subscribe(onNext, onError, onComplete)

fun <T> Single<T>.safeSubscribe(
    onSuccess: OnSuccess<T> = {},
    onError: OnError = defaultOnError
): Disposable = subscribe(onSuccess, onError)

fun <T> Maybe<T>.safeSubscribe(
    onSuccess: OnSuccess<T> = {},
    onError: OnError = defaultOnError,
    onComplete: OnComplete = defaultOnComplete
): Disposable = subscribe(onSuccess, onError, onComplete)
//endregion

fun Disposable.bindTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

//region OnMain
fun <T> Maybe<T>.onMain(): Maybe<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.onMain(): Single<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.onMain(): Flowable<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.onMain(): Observable<T> = observeOn(AndroidSchedulers.mainThread())
//endregion

//region ListMap

inline fun <T, R : Any> Single<out List<T>>.listMap(crossinline transformer: (T) -> R?): Single<List<R>> =
    map { list -> list.mapNotNull { value -> transformer(value) } }

inline fun <T, R : Any> Flowable<out List<T>>.listMap(crossinline transformer: (T) -> R?): Flowable<List<R>> =
    map { list -> list.mapNotNull { value -> transformer(value) } }

//endregion