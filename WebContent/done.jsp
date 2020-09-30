<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Done</title>
</head>
<meta http-equiv="Refresh" content="5;url=admin.jsp">
<body>
<%getServletContext().getRequestDispatcher("/admin.jsp").forward(
        request, response); %>
        
 <%=request.getContextPath()%>/Admin
</body>
</html>