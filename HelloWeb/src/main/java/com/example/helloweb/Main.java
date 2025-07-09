package com.example.helloweb;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/firstServlet")

public class Main extends HttpServlet {
    private String message;

    public void init() {
        message = "Hey there!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Page: 1" + "</h1>");
        out.println("<h2>" + message + "</h2>");
        out.println("<a href='secondServlet'>go next</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}