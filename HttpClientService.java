package com.marion.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HttpClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientService.class);

    @Autowired(required=false)
    private CloseableHttpClient httpClient;

    @Autowired(required=false)
    private RequestConfig requestConfig;



    public String doGet(String url,Map<String,String> params,String charset){
        //访问服务端回传的json数据
        String result=null;
        //判断字符集是否为空，如果为空设置默认值
        if(StringUtils.isEmpty(charset)){
            charset="UTF-8";
        }
        try {
            //判断参数是否为空
            if (params != null) {
                URIBuilder builder = new URIBuilder(url);
                for (Map.Entry<String, String> entry : params.entrySet()){
                    builder.addParameter(entry.getKey(),entry.getValue());
                }
                //自动拼串
                url=builder.build().toString();
            }
            //定义请求类型
            HttpGet httpGet=new HttpGet(url);
            httpGet.setConfig(requestConfig);
            //通过httpclient发送请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                result=EntityUtils.toString(response.getEntity(),charset);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }
    public String doGet(String url){
        return doGet(url,null,null);
    }

    public String doGet(String url,Map<String,String> params){
        return doGet(url,params,null);
    }
    
    public String doPost(String url,Map<String,String> params,String charset){
    	String result = null;
    	
    	//1.判断字符集是否为null
    	if(StringUtils.isEmpty(charset)){
    		
    		charset = "UTF-8";
    	}
    	
    	//2.POST参数提交
    	HttpPost httpPost = new HttpPost(url);
    	httpPost.setConfig(requestConfig);
    	
    	try {
    		if(params !=null){
	    		//3.封装实体对象
	    		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	    		
	    		for (Map.Entry<String,String> param : params.entrySet()) {
					
	    			parameters.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
	    		
	        	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters,charset);
	        	httpPost.setEntity(entity);
    		}
        	
    		//发送post请求
    		CloseableHttpResponse httpResponse = 
    				httpClient.execute(httpPost);
    		
    		if(httpResponse.getStatusLine().getStatusCode() == 200){
    			
    			result = EntityUtils.toString(httpResponse.getEntity(),charset);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    public String doPost(String url){
    	return doPost(url, null, null);
    }
    
    public String doPost(String url,Map<String,String> params){
    	return doPost(url, params, null);
    }

}
