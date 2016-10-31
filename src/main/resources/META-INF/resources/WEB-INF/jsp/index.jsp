<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%>

<%@ page import="ru.naumen.model.WeatherData" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<WeatherData> weather = new ArrayList<>();
    weather.add(new WeatherData("30-10-2016", -1));
    weather.add(new WeatherData("31-10-2016", -3));
%>

<html>
	<body>
		<h1>Hello, ${name}</h1>
		<h2>Weather</h2>
		<ul>
		    <% for(WeatherData item:weather) { %>
		    <li>
    		    <% out.print(item.getDate()); %>
    		    <% out.print(item.getTemperature()); %>
		     </li>
		     <% } %>
		</ul>
	</body>
</html>
