package com.lhy.frams;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserve implements Observer {
    private Disposable mDisposable;


    //订阅
    @Override
    public void onSubscribe(Disposable d) {
        mDisposable=d;
    }

    //获取数据
    @Override
    public void onNext(Object o) {
        getSuccess(o);
        dispose();
    }

    //错误信息
    @Override
    public void onError(Throwable e) {
        getError(e);
        dispose();
    }

    //结束方法

    @Override
    public void onComplete() {
        dispose();
    }

    public abstract void getSuccess(Object o);

    public abstract void getError(Throwable pThrowable);

    //取消订阅
    public void dispose() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
