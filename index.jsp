<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add New Records...!!</h2>
<form action="formdata">
Id : <input type="text" name="id"/><br>
Fist Name : <input type="text" name="first"/><br>
Last Name : <input type="text" name="last"/><br>
Address : <input type="text" name="address"/><br>
City : <input type="text" name="city"/><br>
<input type="submit" value="Submit"><br>
</form>

<a href="viewServlet">View Records</a><a href="update.jsp">Update</a>

</body>
</html>