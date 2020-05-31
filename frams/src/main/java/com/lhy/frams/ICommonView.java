package com.lhy.frams;

public interface ICommonView<D> {

    /**
     * 成功回调
     * @param which 成功接口的标识
     * @param loadType 类型的回调  这个参数就像响应码一样
     * @param pD 一般是实体类的回调,但为了框架的类活性,确保其他一些的偶发性回调,末将长度写死
     *
     * */
    void onSuccess(int which,int loadType,D...pD);



    /**
     * 失败的回调
     * @param which 是哪个接口失败了
     * @param pThrowable 失败的具体描写 错误 异常
     * */
    void errorUI(int which,Throwable pThrowable);
}
