package org.vance.cart.util;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class JsonUtil {

    private static final String DATA = "data";

    public static  <T> T zentaoDataToObj(String zentaoGetJsonStr, Class<T> clazz){
        String dataJson = null;

        JSONObject zentaoGetJson = JSONObject.parseObject(zentaoGetJsonStr);

        if(zentaoGetJson.containsKey(DATA)){
            dataJson = (String) zentaoGetJson.get(DATA);
        }

        if(!StringUtils.isEmpty(dataJson)){
            return JSONObject.parseObject(dataJson, clazz);
        }
        return null;
    }

    public static JSONObject zentaoDataToJson(String zentaoGetJsonStr){
        JSONObject zentaoGetJson = JSONObject.parseObject(zentaoGetJsonStr);
        String dataJson = null;
        if(zentaoGetJson.containsKey(DATA)){
            dataJson = (String) zentaoGetJson.get(DATA);
        }
        return JSONObject.parseObject(dataJson);
    }
}
