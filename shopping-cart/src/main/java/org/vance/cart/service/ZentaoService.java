package org.vance.cart.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.vance.cart.model.zentao.ZentaoProjectBuild;
import org.vance.cart.model.zentao.ZentaoSession;
import org.vance.cart.util.JsonUtil;
import org.vance.cart.util.RestUtil;
import org.vance.cart.util.ZenTaoAPIContent;
import org.vance.cart.util.exception.ZentaoRestException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class ZentaoService {

    private static final String PASSWORD = "A5136381gf";
    private static final String ACCOUNT = "admin";
    /**
     * 获取SessionID
     * @throws IOException
     */
    public ZentaoSession getSessionId() throws ZentaoRestException {
        String restStr = RestUtil.getJsonMethod(ZenTaoAPIContent.GET_SESSIONID, null);
        return JsonUtil.parseZentaoData(restStr, ZentaoSession.class);
    }

    /**
     * 使用获取到的sessionID登录
     */
    public String loginZentao() throws ZentaoRestException {

        ZentaoSession sessionBean = getSessionId();
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
     * 登出禅道
     * @throws ZentaoRestException
     */
    public void logoutZentao() throws ZentaoRestException{
        RestUtil.getJsonMethod(ZenTaoAPIContent.GET_LOGOUT, null);
    }
    // 创建项目
    public String buildProject(String sessionId, ZentaoProjectBuild zentaoProject) throws ZentaoRestException {
        JSONObject projectJson = (JSONObject) JSON.toJSON(zentaoProject);
        String result = RestUtil.postMethod(ZenTaoAPIContent.POST_CREATE_PROJECT + "zentaosid="
                + sessionId, projectJson);

        return result;
    }
//    // 创建产品
//    public void buildProduct(String sessionId, ){
//
//    }

    public static void main(String[] args) throws ZentaoRestException {
        ZentaoService zentaoService = new ZentaoService();
        ZentaoProjectBuild project = new ZentaoProjectBuild();
        project.setName("testProject003");
        project.setCode("testProject003");
        project.setBegin("2020-4-20");
        project.setEnd("2020-4-25");
        System.out.println(zentaoService.buildProject(zentaoService.loginZentao(), project));
    }



}
