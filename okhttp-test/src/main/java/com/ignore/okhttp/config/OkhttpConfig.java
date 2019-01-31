package com.ignore.okhttp.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ignore1992
 * @Description: 配置okhttp
 * @Date: Created In 17:45 2019/1/30
 */
public class OkhttpConfig {
    private static volatile OkHttpClient client = null;

    public static OkHttpClient client(){
        if (client == null){
            synchronized (OkhttpConfig.class){
                if (client == null){
                    client = new OkhttpConfig().init();
                }
            }
        }
        return client;
    }

    public OkHttpClient init(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new OkInterceptor())
                .addNetworkInterceptor(new OkNetInterceptor())
                .retryOnConnectionFailure(true)
                .sslSocketFactory(getTrustedSSLSocketFactory())
                .hostnameVerifier(DO_NOT_VERIFY);
        return builder.build();
    }

    TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] x509Certificates = new X509Certificate[0];
                    return x509Certificates;
                }
                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
    };

    HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private SSLSocketFactory getTrustedSSLSocketFactory() {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            return sc.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
