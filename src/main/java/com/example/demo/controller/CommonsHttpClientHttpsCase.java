package com.example.demo.controller;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @NAME: CommonsHttpClientHttpsCase
 * @USER: 77027
 * @DATE: 2020/12/15
 * @TIME: 16:55
 */
public class CommonsHttpClientHttpsCase {
    public static void main(String[] args) {
        try {
            HttpClient httpClient = new HttpClient();
            /*
             * 请求有权威证书的地址
             */
            String requestPath = "https://www.baidu.com/";
            GetMethod get = new GetMethod(requestPath);
            httpClient.executeMethod(get);
            System.out.println("GET1返回结果：" + new String(get.getResponseBody()));

            /*
             * 请求自定义证书的地址
             */
            //获取信任证书库
            ClassPathResource classPathResource = new ClassPathResource("/demo.cert");
            String path=new CommonsHttpClientHttpsCase().getClass().getResource("/demo.cert").toURI().getPath();
            KeyStore trustStore = getkeyStore("jks", path, "wj20125800");

            //不需要客户端证书
            requestPath = "https://localhost:8080/test?name=wj";
            Protocol.registerProtocol("https", new Protocol("https", new HttpsProtocolSocketFactory(trustStore), 443));
            get = new GetMethod(requestPath);
            httpClient.executeMethod(get);
            Header[] headers = get.getResponseHeaders();
            for (Header h: headers){
                System.out.println(h.getName() + "---------------" + h.getValue());
            }
            System.out.println("GET2返回结果：" + new String(get.getResponseBody()));
            ClassPathResource classPath = new ClassPathResource("/demo.cert");
            System.out.println(classPath.getURL().toURI().getPath());
//            //需要客户端证书
//            requestPath = "https://10.40.103.48:9016/zsywservice";
//            KeyStore keyStore = getkeyStore("pkcs12", "classpath*:demo.cert", "wj20125800");
//            Protocol.registerProtocol("https", new Protocol("https", new HttpsProtocolSocketFactory(keyStore, "wj20125800", trustStore), 443));
//            get = new GetMethod(requestPath);
//            httpClient.executeMethod(get);
//            System.out.println("GET3返回结果：" + new String(get.getResponseBody()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取证书
     *
     * @return
     */
    private static KeyStore getkeyStore(String type, String filePath, String password) {
        KeyStore keySotre = null;
        FileInputStream in = null;
        try {
            keySotre = KeyStore.getInstance(type);
            in = new FileInputStream(new File(filePath));
            keySotre.load(in, password.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtil.close(in);
        }
        return keySotre;
    }

}

final class HttpsProtocolSocketFactory implements ProtocolSocketFactory {
    private KeyStore keyStore;
    private String keyStorePassword;
    private KeyStore trustStore;
    private SSLSocketFactory sslSocketFactory = null;

    public HttpsProtocolSocketFactory(KeyStore keyStore, String keyStorePassword, KeyStore trustStore) {
        this.keyStore = keyStore;
        this.keyStorePassword = keyStorePassword;
        this.trustStore = trustStore;
    }

    public HttpsProtocolSocketFactory(KeyStore trustStore) {
        this.trustStore = trustStore;
    }

    private SSLSocketFactory getSSLSocketFactory() {
        if (sslSocketFactory != null) {
            return sslSocketFactory;
        }
        try {
            KeyManager[] keyManagers = null;
            TrustManager[] trustManagers = null;
            if (keyStore != null) {
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
                keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());
                keyManagers = keyManagerFactory.getKeyManagers();
            }
            if (trustStore != null) {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
                trustManagerFactory.init(trustStore);
                trustManagers = trustManagerFactory.getTrustManagers();
            } else {
                trustManagers = new TrustManager[]{new DefaultTrustManager()};
            }
            //ssl协议
            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(keyManagers, trustManagers, null);
            sslSocketFactory = context.getSocketFactory();
            return sslSocketFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort)
            throws IOException, UnknownHostException {
        return getSSLSocketFactory().createSocket(host, port, localAddress, localPort);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort,
                               HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException {
        if (params == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        int timeout = params.getConnectionTimeout();
        if (timeout == 0) {
            return getSSLSocketFactory().createSocket(host, port, localAddress, localPort);
        } else {
            Socket socket = getSSLSocketFactory().createSocket();
            SocketAddress localAddr = new InetSocketAddress(localAddress, localPort);
            SocketAddress remoteAddr = new InetSocketAddress(host, port);
            socket.bind(localAddr);
            socket.connect(remoteAddr, timeout);
            return socket;
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return getSSLSocketFactory().createSocket(host, port);
    }

}

final class DefaultTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

/**
 * 文件操作工具
 */
class FileUtil {
    private FileUtil() {
    }

    public static void close(InputStream in) {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(OutputStream out) {
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}