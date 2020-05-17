package com.zcf.threadmodule.one.sms.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SmsUtils {
    private static final String SMS_GATEWAY = "url";

    @Value("${yp.apiKey}")
    private static String apiKey;

    private SmsUtils() {
    }

    public static void sendSms(String phone) {
        Map<String, String> param = new HashMap<>();
        param.put("apiKey", apiKey);
        param.put("mobile", phone);
        param.put("text", "短信模板");
        System.out.println("====apiKey========");
        System.out.println(apiKey);
        System.out.println("====apiKey========");
//        post(SMS_GATEWAY, param);   //实际http请求
        //用睡眠模拟请求
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String post(String url, Map<String, String> param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                param.forEach((key,value)->{
                    NameValuePair nameValuePair = new BasicNameValuePair(key, value);
                    paramList.add(nameValuePair);
                });
                post.setEntity(new UrlEncodedFormEntity(paramList,"UTF-8"));
            }
            CloseableHttpResponse response = null;

            response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            String responseText = EntityUtils.toString(entity);
            return responseText;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
