package com.solo.common.rxjava;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by solo on 2018/1/24.
 */

public class ClosableRxJavaExecuter implements RxExecuter{

    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public <T> void execute(Single<T> single, Consumer<T> consumer) {

        mCompositeDisposable.add(single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer));
    }
}
