<%--
  Created by IntelliJ IDEA.
  User: Tocka Ayman
  Date: 4/24/2018
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get Goal Reports</title>
</head>
<body>
<table>
    <tr>
        <th>Goal Minutes</th>
        <th>Exercise Minutes</th>
        <th>Exercise Activity</th>
    </tr>
    <c:forEach items="${goalReports}" var="goalReport">
        <tr>
            <td>${goalReport.goalMinutes}</td>
            <td>${goalReport.exerciseMinutes}</td>
            <td>${goalReport.exerciseActivity}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
