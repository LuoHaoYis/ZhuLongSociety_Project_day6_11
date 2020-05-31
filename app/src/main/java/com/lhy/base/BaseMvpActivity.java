package com.lhy.base;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.lhy.frams.CommonPresenter;
import com.lhy.frams.ICommonModel;
import com.lhy.frams.ICommonView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView {
    private M mModel;
    public CommonPresenter commonPresenter;
    private Unbinder bind;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        bind = ButterKnife.bind(this);
        mModel=getModel();
        commonPresenter = new CommonPresenter<>(this, mModel);
        initView();
        initData();
    }

    protected abstract void initData();


    protected abstract void initView();

    protected abstract M getModel();

    protected abstract int getLayout();

    protected abstract void getSuccess(int which, int loadType, Object[] pD);
    protected  void getError(int which, Throwable pThrowable){

    }

    @Override
    public void onSuccess(int which, int loadType, Object[] pD) {
        getSuccess(which,loadType,pD);
    }

    @Override
    public void errorUI(int which, Throwable pThrowable) {
        showLog("net work error: " + which + "error content" + pThrowable != null
                && !TextUtils.isEmpty(pThrowable.getMessage()) ? pThrowable.getMessage() : "不明错误类型");

        getError(which,pThrowable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
