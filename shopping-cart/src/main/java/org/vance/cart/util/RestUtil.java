package org.vance.cart.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;
import org.vance.cart.util.exception.ZentaoRestException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class RestUtil {
    //get

    public static String getJsonMethod(String url, JSONObject paramJson) throws ZentaoRestException {
        BufferedReader br = null;
        String paramStr = RestUtil.buildParam(paramJson);
        if(!StringUtils.isEmpty(paramStr)){
            url = url + "?" + paramStr;
        }
        try {

            URL restURL = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
            conn.setRequestMethod("GET"); // POST GET PUT DELETE
            conn.setRequestProperty("Accept", "application/json");

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer buffer = new StringBuffer();
            String line;
            while((line = br.readLine()) != null ){
                buffer.append(line);
            }
            return buffer.toString();
        } catch (IOException e){
            // TODO write log
            throw new ZentaoRestException("连接禅道客户端失败,rest接口调用失败！", e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new ZentaoRestException("连接禅道客户端,数据流关闭失败！", e);
            }
        }

    }

    //post
    public static String postMethod(String url, JSONObject paramJson) throws ZentaoRestException {

        String query = RestUtil.buildParam(paramJson);
        PrintStream ps = null;
        BufferedReader br = null;
        StringBuffer resultStr = new StringBuffer();
        try {
            URL restURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
            conn.setRequestMethod("POST");
            //conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            ps = new PrintStream(conn.getOutputStream());
            ps.print(query);

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while((line = br.readLine()) != null ){
                resultStr.append(line);
            }

        } catch (IOException e) {
            // TODO write log
            throw new ZentaoRestException("连接禅道客户端失败,rest接口调用失败！", e);

        } finally {
            try {
                ps.close();
                br.close();
            } catch (IOException e) {
                // TODO write log
                e.printStackTrace();
            }
        }
        return resultStr.toString();

    }

    public static String buildParam(JSONObject paramJson){
        StringBuffer buffer = new StringBuffer();
        if(paramJson == null || paramJson.isEmpty()){
            return "";
        }

        for(String key : paramJson.keySet()){
            if(paramJson.get(key) != null){
                buffer.append(key).append("=").append(paramJson.get(key)).append("&");
            }
        }
        return buffer.substring(0, buffer.lastIndexOf("&"));
    }

}
