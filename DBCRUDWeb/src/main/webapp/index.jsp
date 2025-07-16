<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome to CRUD project!</h1>

<!-- src/main/webapp/index.jsp -->
<form action="welcome" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id"  /><br/><br/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"  /><br/><br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"  /><br/><br/>

    <button type="submit" name="action" value="submit">Submit</button>
    <button type="submit" name="action" value="delete">Delete</button>
    <button type="submit" name="action" value="view">View</button>
    <button type="submit" name="action" value="update">update</button>

</form>


</body>
</html>