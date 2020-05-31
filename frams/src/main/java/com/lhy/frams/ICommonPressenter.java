package com.lhy.frams;

import io.reactivex.disposables.Disposable;

/**
 * 1.由他作为中间层发起网络请求;
 * 2.将请求的结果回调到view层
 **/

public interface ICommonPressenter<P> extends ICommonView {

    /**
     * @param which 1,当一个页面中多个网络请求,用于区分哪一个任务执行完成
     *                 2.望文生义,方便后期维护时了解接口的作用
     * @param pS 1,一般用于网络请求时,如果参数是从view层动态获取的,需要通过这个可变长度的数组进行传递
     *            2.另外如果有其他参数传递的需求,也可以加入到该数组中,但切记,在取出参数的时候一定要确保存放的时候的顺序
     *
     * */
    void getData(int which,P...pS);

    void addObserver(Disposable pDisposable);
}
