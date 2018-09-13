package com.codecool.webroute;

import javax.xml.ws.spi.http.HttpHandler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebRoute {

    enum HttpMethods {
        POST,
        GET
    }

    String route();

    HttpMethods[] httpMethods() default HttpMethods.GET;
}
