package com.codecool.webroute;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class RunServer {

    public static void main(String[] args) throws Exception {

        Class route = Route.class;

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        for (Method method : route.getMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {

                for (Annotation annotation : method.getAnnotations()) {
                    HttpHandler handler = (HttpHandler) route.newInstance();
                    method.invoke(handler);
                    server.createContext(((WebRoute) annotation).route(), handler);
                }
            }
        }

        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
