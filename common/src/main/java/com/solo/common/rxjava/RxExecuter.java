package com.solo.common.rxjava;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

/**
 * Created by solo on 2018/1/24.
 */

public interface RxExecuter {

    <T> void execute(Single<T> single, Consumer<T> onSuccess);

    <T> void execute(Single<T> single, Consumer<T> onSuccess, Consumer<Throwable> onError);

    <T> void execute(Single<T> single, Consumer<T> onSuccess, Consumer<Throwable> onError, boolean timeOut);

    <T> void execute(Single<T> single, SingleObserver<T> observer, boolean timeOut);

    <T> void execute(Single<T> single, BiConsumer<T, Throwable> biConsumer, boolean timeOut);

    void execute(Completable completable, Action onComplete);

    void execute(Completable completable, Action onComplete, Consumer<Throwable> onError);

    void execute(Completable completable, Action onComplete, Consumer<Throwable> onError, boolean timeOut);


    /**
     * 取消订阅
     */
    void close();
}
