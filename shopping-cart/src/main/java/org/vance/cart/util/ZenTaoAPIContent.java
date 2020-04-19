package org.vance.cart.util;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class ZenTaoAPIContent {
    public static String IP = "http://123.207.222.13/zentao/";

    /**
     * 登录验证
     */
    // 获取SessionID
    public static final String GET_SESSIONID = IP + "api-getsessionid.json";
    // 登录
    public static final String POST_LOGIN = IP + "user-login.json?";
    // 登出
    public static final String GET_LOGOUT = IP + "user-logout.json";

    /**
     * 项目接口
     */
    public static final String POST_CREATE_PROJECT = IP + "api-getModel-project-create-copyProjectID=1.json";
}
