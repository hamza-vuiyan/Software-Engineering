package com.example.helloweb;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "newServlet", value = "/secondServlet")

public class TestPage extends HttpServlet {
    private String message;

    public void init() {
        message = "Congrats! You reached the last page!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Page: 2" + "</h1>");
        out.println("<h2>" + message + "</h2>");
        out.println("<a href='index.jsp'>go home</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}