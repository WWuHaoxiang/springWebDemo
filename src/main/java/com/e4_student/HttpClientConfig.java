package com.e4_student;

import lombok.Data;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "httpclient")
@Data
public class HttpClientConfig {
    private Integer maxTotal;
    private Integer defaultMaxPerRoute;
    private Integer connectTimeout;
    private Integer connectionRequestTimeout;
    private Integer socketTimeout;

    @Bean
    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return connectionManager;
    }

    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
    }

    @Bean
    public CloseableHttpClient httpClient(HttpClientConnectionManager manager, RequestConfig config) {
        return HttpClientBuilder.create()
                .setConnectionManager(manager)
                .setDefaultRequestConfig(config)
                .build();
    }
}