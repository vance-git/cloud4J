package org.vance.cart.util;

import com.alibaba.fastjson.JSONObject;
import org.vance.cart.model.zentao.ZentaoSessionBean;
import org.vance.cart.util.exception.ZentaoRestException;

import java.io.IOException;
/**
 * @Description: 登陆并获取session（单例）
 * @Author: gaofan 12183
 */
public class ZentaoSession {

    private static final String PASSWORD = "wangyigaofan@163.com";
    private static final String ACCOUNT = "admin";

    private static ZentaoSession zentaoSession;

    private String session;

    private ZentaoSession(String session){
        this.session = session;
    }

    public static ZentaoSession getInstance() throws ZentaoRestException {
        if (zentaoSession == null || zentaoSession.session == null) {
            zentaoSession = new ZentaoSession(loginZentao());
        }
        return zentaoSession;
    }

    /**
     * 使用获取到的sessionID登录
     */
    private static String loginZentao() throws ZentaoRestException {

        ZentaoSessionBean sessionBean = getSessionId();
        JSONObject loginJson = new JSONObject();
        loginJson.put("account", ACCOUNT);
        loginJson.put("password", PASSWORD);
        String result = RestUtil.postMethod(ZenTaoAPIContent.POST_LOGIN + "zentaosid="
                + sessionBean.getSessionID(), loginJson);
        if(result.contains("account")){
            return sessionBean.getSessionID();
        }
        return "";
    }
    /**
     * 获取SessionID
     * @throws IOException
     */
    private static ZentaoSessionBean getSessionId() throws ZentaoRestException {
        String restStr = RestUtil.getJsonMethod(ZenTaoAPIContent.GET_SESSIONID, null);
        return JsonUtil.zentaoDataToObj(restStr, ZentaoSessionBean.class);
    }

    /**
     * 登出禅道
     * @throws ZentaoRestException
     */
    public void logoutZentao() throws ZentaoRestException{
        RestUtil.getJsonMethod(ZenTaoAPIContent.GET_LOGOUT, null);
        this.session = null;
    }


    public String getSession() {
        return session;
    }
}
