package com.amir.dbcrudweb;

import java.io.*;
import java.sql.Struct;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.plaf.IconUIResource;

@WebServlet(name = "welcome", value = "/welcome")


public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String action = request.getParameter("action");

        String confirmation = "Unknown action!";
        boolean view = false;
        try{
            switch (action) {
                case "submit":
                    confirmation = Services.insertData(id, name, email);
                    break;
                case "delete":
                    confirmation = Services.deleteData(id);
                    break;
                case "view":
                    view = true;
                    List<ModelView> students = Services.viewAll();
                    request.setAttribute("students", students);
                    request.getRequestDispatcher("students.jsp").forward(request, response);
                    break;
                case "update":
                    if(id == "" || name == "" || email == ""){
                        confirmation = "ID, Name, and Email cannot be empty.";
                    } else {
                        confirmation = Services.updateQuery(id, name, email);
                    }

                default:
                    break;
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }


        if(view == false){
            out.println("<html><body>");
            out.println("<p>status: " + confirmation + "</p>");
            out.println("</body></html>");
        }
    }
}