<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : insertOwnwer
    Created on : Jul 3, 2014, 11:45:18 PM
    Author     : Joas Mogale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="Insert.jsp"> 
        <table>
            <tr><td>Name:</td><td><input type="text" name="name"></td></tr>
            <tr><td>Type:</td><td><input type="text" name="type"></td></tr>
            <tr><td>Address:</td><td><input type="text" name="addr"></td></tr>
            <tr><td>ID/Reg#</td><td><input type="password" name="reg"></td></tr>
            <tr><td></td><td><input type="submit" value="Submit"></td></tr>
        </table>
        </form>
    </body>
</html>
