<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.naumen.model.WeatherData" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<String> weather = new ArrayList<>();
    weather.add("String 1");
    weather.add("String 2");
%>

<html>
	<body>
		<h1>Hello, ${name}</h1>
		<h2>Weather</h2>
		<ul>
		    <% for(String item:weather) { %>
		    <li>
    		    <% out.print(item); %>
		     </li>
		     <% } %>
		</ul>
	</body>
</html>
