package com.solo.common.rxjava;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

/**
 * Created by solo on 2018/1/24.
 */

public interface RxExecuter {

    <T> void execute(Single<T> single, Consumer<T> consumer);
}
