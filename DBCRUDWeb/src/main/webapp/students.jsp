<%--
  Created by IntelliJ IDEA.
  User: amir
  Date: 7/16/25
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.amir.dbcrudweb.ModelView" %>
<%
  List<ModelView> students = (List<ModelView>) request.getAttribute("students");
%>
<html>
<head>
  <title>Students List</title>
  <style>
    table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }
  </style>
</head>
<body>
<h2>Students List</h2>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
  </tr>
  <%
    if (students != null) {
      for (ModelView student : students) {
        if(student == null) {
          continue; // Skip null entries
        }
  %>
  <tr>
    <td><%= student.getId() %></td>
    <td><%= student.getName() %></td>
    <td><%= student.getEmail() %></td>
  </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>