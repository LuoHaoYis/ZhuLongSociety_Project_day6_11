package com.lhy.model;


import com.lhy.frams.ICommonModel;
import com.lhy.frams.ICommonPressenter;
import com.lhy.frams.NetManger;

import java.util.Map;

//建议:一个独立单元使用一个model,比如账号注册 验证码注册 账号登录 验证码登录 第三番登录
public class CommonModel implements ICommonModel {

    NetManger netManger=NetManger.netManger();
    @Override
    public void getData(ICommonPressenter iCommonPressenter, int which, Object[] pT) {
        int loadType = (int) pT[0];
        Map map=(Map) pT[1];
        int page=(int) pT[2];
        netManger.netWork(netManger.getServicer().getDataBean(),iCommonPressenter,which,loadType);
    }
}
