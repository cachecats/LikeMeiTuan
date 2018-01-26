package com.solo.common.rxjava;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by solo on 2018/1/24.
 * 封装的 RxJava 工具类
 */

public class CloseableRxServiceExecutor implements RxExecuter {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private static final int TIME_OUT = 30000;

    @Inject
    public CloseableRxServiceExecutor() {
    }

    @Override
    public <T> void execute(Single<T> single, Consumer<T> onSuccess) {
        execute(single, onSuccess, getDefaultOnError(), false);
    }

    @Override
    public <T> void execute(Single<T> single, Consumer<T> onSuccess, Consumer<Throwable> onError) {
        execute(single, onSuccess, onError, false);
    }

    @Override
    public <T> void execute(Single<T> single, Consumer<T> onSuccess, Consumer<Throwable> onError, boolean timeOut) {
        if (timeOut) {
            mCompositeDisposable.add(
                    single.timeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onSuccess, onError)
            );
        } else {
            mCompositeDisposable.add(
                    single.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onSuccess, onError)
            );
        }
    }

    @Override
    public <T> void execute(Single<T> single, SingleObserver<T> observer, boolean timeOut) {
        if (timeOut) {
            single.timeout(TIME_OUT, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            single.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }

    }

    @Override
    public <T> void execute(Single<T> single, BiConsumer<T, Throwable> biConsumer, boolean timeOut) {
        if (timeOut) {
            mCompositeDisposable.add(
                    single.timeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(biConsumer)
            );
        } else {
            mCompositeDisposable.add(
                    single.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(biConsumer)
            );
        }
    }

    @Override
    public void execute(Completable completable, Action onComplete) {
        execute(completable, onComplete, getDefaultOnError(), false);
    }

    @Override
    public void execute(Completable completable, Action onComplete, Consumer<Throwable> onError) {
        execute(completable, onComplete, onError, false);
    }

    @Override
    public void execute(Completable completable, Action onComplete, Consumer<Throwable> onError, boolean timeOut) {
        if (timeOut) {
            mCompositeDisposable.add(
                    completable.timeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onComplete));
        } else {
            mCompositeDisposable.add(
                    completable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onComplete));
        }
    }

    /**
     * 取消订阅
     */
    @Override
    public void close() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
    }

    /**
     * 默认的错误处理
     *
     * @return
     */
    private Consumer<Throwable> getDefaultOnError() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Logger.e(throwable, throwable.toString(), throwable);
            }
        };
    }
}
