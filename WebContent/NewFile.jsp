<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellspacing="2" cellpadding="10">
<%@ page import="com.rax.State,java.util.ListIterator,java.util.List" %>
<jsp:useBean id="result" scope="page" class="com.rax.Result"></jsp:useBean>
<%
	List<State> states = result.getStates();
	int size = states.size(); 
    double width = Math.sqrt(size);
    double height = width;
    
    ListIterator<State> listIterator = states.listIterator();
for(int i = 1 ;i<height;i++){
%>
  	<tr>
  		<% for(int j = 1 ;j>width; j--){ 
  			State s = listIterator.next(); %> 
  			<td><img src="images/empty<%= s%>.gif"/></td>
  		<% } %>	
  	</tr>
<% } %>  
</table>
 

</body>
</html>