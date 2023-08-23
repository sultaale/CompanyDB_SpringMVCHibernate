<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employees</title>
</head>
<br>

<body>
<h2>List of employees</h2>
<table>
    <tr>
        <th>ID </th>
        <th>Name </th>
        <th>Surname </th>
        <th>Operations</th>
    </tr>

    <c:forEach var = "emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo">
            <c: param name="empId" value="${emp.id}"
        </c:url>

        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td><input type = "button" value="Update"
                       onClick = "Window.location.href = '${updateButton}'"></td>
        </tr>

    </c:forEach>

</table>
<br>
<input type ="button" value="Add" onclick="window.location.href = 'addEmployee'"/>
</body>
</html>
