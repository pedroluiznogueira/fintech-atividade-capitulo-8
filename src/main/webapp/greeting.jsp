<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
    <p>Hello <%= request.getAttribute("loginName") %></p>
</body>
</html>
