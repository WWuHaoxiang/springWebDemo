package net.clientOfWuHX;

import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ClientOfWuHX {
    public static void main(String[] args) {
        System.out.println(ClientOfWuHX.GET_3121005143());
        System.out.println(ClientOfWuHX.POST(Long.parseLong("3121005011"), "吴凯越"));
        System.out.println(ClientOfWuHX.POST(Long.parseLong("3121005126"), "黄晓峰"));
        System.out.println(ClientOfWuHX.POST(Long.parseLong("3121005037"), "李方洋"));
        System.out.println(ClientOfWuHX.DELETE(Long.parseLong("3121005011")));
        System.out.println(ClientOfWuHX.DELETE(Long.parseLong("3121005126")));
        System.out.println(ClientOfWuHX.DELETE(Long.parseLong("3121005037")));
        System.out.println(ClientOfWuHX.PUT_wuhaoxiang());
    }

    private static HttpPost getHttpPost(long studentId, String name) {
        HttpPost httpPost = new HttpPost("http://localhost:8081/student");

        // 设置POST请求头
        httpPost.addHeader("Content-Type", "application/json");
        // 设置 POST 请求参数
        String requestBody = "{\"studentId\": " + studentId + " ,\"name\": \"" + name + "\"}";
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

    private static CloseableHttpResponse POST(long studentId, String name){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = getHttpPost(studentId, name);

            return client.execute(httpPost);

        } catch (IOException e) {
            // 处理异常
            System.out.println("IOException");
            return null;
        }
    }

    private static CloseableHttpResponse DELETE(Long studentId){
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete("http://localhost:8081/student/" + studentId);

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
