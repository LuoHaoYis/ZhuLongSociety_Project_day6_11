package com.lhy.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lhy.frams.CommonPresenter;
import com.lhy.frams.ICommonModel;
import com.lhy.frams.ICommonView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpFragment<M extends ICommonModel> extends BaseFragment implements ICommonView {

    private M mModel;
    private CommonPresenter commonPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container, false);
        bind = ButterKnife.bind(getActivity());
        mModel = getModel();
        commonPresenter = new CommonPresenter<>(this, mModel);
        initView(inflate);
        initData();
        return inflate;
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract M getModel();

    protected abstract int getLayout();
    protected abstract void getSuccessUI(int which, int loadType, Object[] pD);
    protected void getErrorUI(int which, Throwable pThrowable){

    }
    @Override
    public void onSuccess(int which, int loadType, Object[] pD) {
        getSuccessUI(which,loadType,pD);
    }

    @Override
    public void errorUI(int which, Throwable pThrowable) {
        showLog("net work error: " + which + "error content" + pThrowable != null
                && !TextUtils.isEmpty(pThrowable.getMessage()) ? pThrowable.getMessage() : "不明错误类型");

        getErrorUI(which,pThrowable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
