<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Fitness Tracker Custom Login Page</title>
    <style type="text/css">
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body onload='document.f.j_username.focus();'>
<h3>Fitness Tracker Custom Login Page</h3>
<c:if test="${not empty error}">
    <div class="errorblock">
        Your login was unsuccessful. <br />
        Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
    </div>
</c:if>

<form th:action="login" name="f" method="post">
    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username" value=""></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="Submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>

