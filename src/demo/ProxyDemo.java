package demo;

import java.net.*;
import java.io.*;
import java.util.*;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ProxyDemo {
	public static void main(String args[]) throws Exception {
		 // 创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        // HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
      
        // 依次是代理地址，代理端口号，协议类型  
        HttpHost proxy = new HttpHost("58.208.235.225", 808, "http");  
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();  

        HttpGet httpget = new HttpGet("http://www.ifeng.com");  
        httpget.setConfig(config);
        
        CloseableHttpResponse response = closeableHttpClient.execute(httpget);  
        HttpEntity entity = response.getEntity();  
        
        if(response.getStatusLine().getStatusCode() == 200) {
        	System.out.println(EntityUtils.toString(entity).trim());
        } else {
        	System.out.println(response.getStatusLine().getStatusCode());
        }
	}

}