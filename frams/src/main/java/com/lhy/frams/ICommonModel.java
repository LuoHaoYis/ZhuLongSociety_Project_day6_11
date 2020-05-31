package com.lhy.frams;

public interface ICommonModel<T> {

    /**
     * @param iCommonPressenter  这就是 p层 对象
     * @param which 接口的标识 从 v 层到 p层 再从p 层到m层 然后获取到数据的时候 还是这个标识 返回的时候 也还是他
     * @param loadType 用于 区分 刷新 加载 正常获取数据 的标识
     * @param pT 可变参数 get请求 拼接到网址上的参数 还有个页数
     * */

    void getData(ICommonPressenter iCommonPressenter,int which,T...pT);
}
