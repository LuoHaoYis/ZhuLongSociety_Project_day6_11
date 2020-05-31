package com.lhy.frams;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManger {
    public NetManger() {
    }

    private static volatile NetManger sNetManger;
    //单列模式 懒汉
    public static NetManger netManger(){
        if (sNetManger == null) {
            synchronized (NetManger.class) {
                sNetManger=new NetManger();
            }
        }
        return sNetManger;
    }
    /**
     * 在m层调用这个方法时 可以传入base_url
     * 可以替换这个 base_url
     * */
    public <T> ApiService getServicer(T...pT){
        String baseUrl=ServerAddessConfig.BASE_URL;
        if (pT != null && pT.length != 0) {
            baseUrl=(String) pT[0];
        }

        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient())
                .build()
                .create(ApiService.class);
    }


    //使用observer观察者，抽取出网络请求及切换线程的过程
    public <T, O> void netWork(Observable<T> localTestInfo, final ICommonPressenter iCommonPressenter , final int which, final int loadType, O... pO) {
        localTestInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserve() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        iCommonPressenter.addObserver(d);
                    }

                    @Override
                    public void getSuccess(Object o) {
                        iCommonPressenter.onSuccess(which,loadType,o);
                    }

                    @Override
                    public void getError(Throwable pThrowable) {
                        iCommonPressenter.errorUI(which,pThrowable);
                    }
                });
    }
}
