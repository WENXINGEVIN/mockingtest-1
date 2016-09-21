<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p>You are not authorized to access this page </p>
    <p><a href="<c:url value="/logout" />" > Logout</a></p>
</body>
</html>