
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>未授权跳转页面</title>
</head>
<body>
认证未通过，或者权限不足
<a href="${pageContext.request.contextPath }/user/logout">退出</a>
</body>
</html>
