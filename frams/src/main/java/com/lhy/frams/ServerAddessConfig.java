package com.lhy.frams;

public class ServerAddessConfig {

    public static String BASE_URL="";
    public static int STATE=3;//外网 内网 外部正式网;


    static{
        switch (STATE) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                BASE_URL="http://static.owspace.com/";
                break;
        }
    }
}
