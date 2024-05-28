package com.e4_student;

import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        System.out.println(Client.GET_3121005143());
        System.out.println(Client.POST_3121005040());
        System.out.println(Client.DELETE_3121005040());
        System.out.println(Client.PUT_wuhaoxiang());
    }

    private static HttpPost getHttpPost() {
        HttpPost httpPost = new HttpPost("http://localhost:8081/student");

        // 设置POST请求头
        httpPost.addHeader("Content-Type", "application/json");
        // 设置 POST 请求参数
            String requestBody = """
                {
                  "studentId": 3121005040,
                  "name": "lizhen"
                }""";
        httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        return httpPost;
    }

    private static HttpPut getHttpPut() {
        // 简单版：HttpPut httpPut = new HttpPut("http://localhost:8081/student/3121005143?name=wuhaoxiang");
        HttpPut httpPut = new HttpPut("http://localhost:8081/student/3121005143");

        // 设置PUT请求头
        httpPut.addHeader("Content-Type", "application/json");
        // 设置 PUT 请求参数
        String requestBody = """
                {
                  "name": "wuhaoxiang"
                }""";
        httpPut.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        return httpPut;
    }

    private static CloseableHttpResponse GET_3121005143(){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8081/student/3121005143");

            return client.execute(httpGet);


        } catch (IOException e) {
            // 处理异常
            System.out.println("IOException");
            return null;
        }
    }

    private static CloseableHttpResponse POST_3121005040(){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = getHttpPost();

            return client.execute(httpPost);

        } catch (IOException e) {
            // 处理异常
            System.out.println("IOException");
            return null;
        }
    }

    private static CloseableHttpResponse DELETE_3121005040(){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete("http://localhost:8081/student/3121005040");

            return client.execute(httpDelete);


        } catch (IOException e) {
            // 处理异常
            System.out.println("IOException");
            return null;
        }
    }

    private static CloseableHttpResponse PUT_wuhaoxiang(){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPut httpPut = getHttpPut();

            return client.execute(httpPut);

        } catch (IOException e) {
            // 处理异常
            System.out.println("IOException");
            return null;
        }
    }
}
