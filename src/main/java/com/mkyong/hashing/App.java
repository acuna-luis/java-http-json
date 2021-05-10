package com.mkyong.hashing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import com.google.gson.Gson;

public class App{
public static void main(String args[]){
    try{
        LoginCredentials credentials=new LoginCredentials();
        credentials.username = "admin";
        credentials.password = "admin";
        Gson gson = new Gson();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpClient   httpClient    = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://172.30.4.133:8081/relatorios/vivo/users/login");
        StringEntity postingString = new StringEntity(gson.toJson(credentials));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse  response = httpClient.execute(post);
        System.out.println(response.getStatusLine());
        client.close();
    }catch(ClientProtocolException e) {
        System.out.println(e.getMessage());

    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}}