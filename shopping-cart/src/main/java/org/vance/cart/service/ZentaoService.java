package org.vance.cart.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.vance.cart.model.zentao.ZentaoProductCreate;
import org.vance.cart.model.zentao.ZentaoProjectBasic;
import org.vance.cart.model.zentao.ZentaoProjectCreate;
import org.vance.cart.util.JsonUtil;
import org.vance.cart.util.RestUtil;
import org.vance.cart.util.ZenTaoAPIContent;
import org.vance.cart.util.ZentaoSession;
import org.vance.cart.util.exception.ZentaoRestException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class ZentaoService {

    private static final String JSON_SUFFIX = "&t=json";
    private static final String PROJECTS = "projects";
    private static final String PRODUCTS = "products";

    private String session;

    public ZentaoService() throws ZentaoRestException {
        session = "?zentaosid=" + ZentaoSession.getInstance().getSession();
    }
    /**
     *
     * @param zentaoProjectCreate
     * @return
     * @throws ZentaoRestException
     */
    public String buildProject(ZentaoProjectCreate zentaoProjectCreate) throws ZentaoRestException {
        JSONObject projectJson = (JSONObject) JSON.toJSON(zentaoProjectCreate);
        String url = ZenTaoAPIContent.POST_CREATE_PROJECT + session + JSON_SUFFIX;
        String result = RestUtil.postMethod(url, projectJson);
        return result;
    }

    /**
     * 获取所有项目
     * @return
     * @throws ZentaoRestException
     */
    public List<ZentaoProjectBasic> getAllProject() throws ZentaoRestException {
        List<ZentaoProjectBasic> basicProjectInfoList = new ArrayList<>();
        // 获取所有项目
        String result = RestUtil.postMethod(ZenTaoAPIContent.GET_ALL_PROJECT + session + JSON_SUFFIX , null);
        // 解析json
        JSONObject jsonData = JsonUtil.zentaoDataToJson(result);
        JSONObject projectJson = null;
        if(jsonData.containsKey(PROJECTS)){
            projectJson = JSONObject.parseObject(jsonData.getString(PROJECTS));
        }
        // 组装数据
        for(String key: projectJson.keySet()){
            basicProjectInfoList.add(new ZentaoProjectBasic(key, projectJson.getString(key)));
        }
        return basicProjectInfoList;
    }

//    public String buildProduct(ZentaoProductCreate product){
//
//    }

    /**
     * 获取所有产品
     */
    public String getAllProduct() throws ZentaoRestException {
        // 获取所有产品
        String result = RestUtil.postMethod(ZenTaoAPIContent.GET_ALL_PRODUCT + session + JSON_SUFFIX , null);
        // 解析json
        JSONObject jsonData = JsonUtil.zentaoDataToJson(result);
        JSONObject projectJson = null;
        if(jsonData.containsKey(PRODUCTS)){
            projectJson = JSONObject.parseObject(jsonData.getString(PRODUCTS));
        }
        // 组装数据
        return result;
    }
//    public String deleteProject(String projectId){
//
//    }

//    // 创建产品
//    public void buildProduct(String sessionId, ){
//
//    }

    public static void main(String[] args) throws ZentaoRestException {
        ZentaoService zentaoService = new ZentaoService();

        // 获取所有
        zentaoService.getAllProduct();
        // 获取所有项目
//        List<ZentaoProjectBasic> projectBasics = zentaoService.getAllProject();

        // 创建项目
//        ZentaoProjectBuild project = new ZentaoProjectBuild();
//        project.setName("testProject006");
//        project.setCode("testProject006");
//        project.setBegin("2020-4-20");
//        project.setEnd("2020-4-25");
//        project.setDays(5);
//        System.out.println(zentaoService.buildProject(project));
    }



}
