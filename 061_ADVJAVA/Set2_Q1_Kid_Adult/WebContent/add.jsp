<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="AddUserServlet" method="Post">
			<br> First Name : <input type="text" name="fName" /><br>
			last Name : <input type="text" name="lName" /><br> Age : <select
				name=uAge>
				<%!int i=1; %>
				<%
				for(i=1;i<101;i++)
				{ %>
				<option value=<%=i %>><%=i %></option>

				<%} %>
			</select> <input type="submit" value="Add-Info" />
		</form>
	</center>
</body>
</html>