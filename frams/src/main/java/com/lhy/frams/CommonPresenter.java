package com.lhy.frams;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class CommonPresenter<V extends ICommonView,M extends ICommonModel> implements ICommonPressenter  {
    private SoftReference<V> mView;
    private SoftReference<M> mModel;
    private List<Disposable> setList;


    public CommonPresenter(V pView, M pModel) {
        mView = new SoftReference<>(pView);
        mModel = new SoftReference<>(pModel);
        setList=new ArrayList<>();
    }

    /**
     * p层调用m层获取数据 this是把p层对象传到m层 因为要把m层获取到的数据拿到p层
     *         要把this 传过去 才能使用 成功或失败的方法
     * */
    @Override
    public void getData(int which, Object[] pS) {
        if (mModel != null && mModel.get() != null) {
            mModel.get().getData(this,which,pS);
        }
    }

    @Override
    public void addObserver(Disposable pDisposable) {
        if (setList == null) {
            return;
        }
        setList.add(pDisposable);
    }

    /**
     * presenter继承了view接口 重写了成功方法 p层传数据到v层
     *
     * */
    @Override
    public void onSuccess(int which, int loadType, Object[] pD) {
        if (mView != null && mView.get() != null) {
            mView.get().onSuccess(which,loadType,pD);
        }
    }
    /**
    * presenter 继承了 view接口 重写了失败方法
    *
    *
    **/

    @Override
    public void errorUI(int which, Throwable pThrowable) {
        if (mView != null && mView.get() != null) {
            mView.get().errorUI(which,pThrowable);
        }
    }

    public void setClear(){
        for (int i = 0; i < setList.size(); i++) {
            Disposable disposable = setList.get(i);
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        if (mModel != null) {
            mModel.clear();
            mModel=null ;
        }
    }
}
