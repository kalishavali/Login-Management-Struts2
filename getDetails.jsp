<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>
<%@ page import="java.util.*"
%> 
<%	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
result=(ArrayList<ArrayList<String>>)request.getAttribute("result");
Iterator<ArrayList<String>> first=result.iterator();
while(first.hasNext()){
	ArrayList<String> second=first.next();
	Iterator<String> itr=second.
}
%>
<table style="width:100%">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>		
    <th>Points</th>
  </tr>
 
 <%for(int i=0;i<result.size();i++){
	 out.println("<tr>");
	 out.println("<td>"+result.get(i)+"</td>");
	 out.println("</tr>");
 } %>
</table>
</body>
</html>
