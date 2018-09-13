package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Route implements HttpHandler {

    private String response = "This is the response";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(route = "/test")
    public void routeTest() {
        this.response = "This is another test";
    }

    @WebRoute(route = "/home")
    public void routeHome() {
        this.response = "Homepage of my test";
    }

    @WebRoute(route = "/")
    public void routeRootPage() {
        this.response = "This is the root\n<a href=\"/test\">This is a test</a>";
    }
}
