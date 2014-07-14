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
        <form method="post" action="insertV.jsp"> 
        
        <table>
            <tr><b>Vehicle Features</b></tr>
            <tr><td>Make:</td><td><input type="text" name="make"></td></tr>
            <tr><td>Type:</td><td>  <input type="radio" name="type" value="Sedan">Sedan<br>
                                    <input type="radio" name="type" value="Hatch">Hatch<br>
                                    <input type="radio" name="type" value="SUV">SUV<br>
                                    <input type="radio" name="type" value="Van">Van<br>
                                    <input type="radio" name="type" value="Truck">Truck<br>
                                    <input type="radio" name="type" value="Trailer">Trailer<br>
                                </td></tr>
            <tr><td>Model:</td><td><input type="text" name="model"></td></tr>
            <tr><td>Color:</td><td><input type="text" name="colour"></td></tr>
        </table>
        <table>
            <br>
            <tr><b>Vehicle Particulars</b></tr>
            <tr><td>Number Plate:</td><td><input type="text" name="plate"></td></tr>
            <tr><td>Owner ID or Reg Number:</td><td><input type="text" name="owner"></td></tr>
            <tr><td>Stolen:</td><td><input type="checkbox" value="stolen" name="stolen"></td></tr>
            <tr><td>Fines:</td><td><input type="checkbox" value="fines" name="fines"></td></tr>
            <tr><td>Road worthy:</td><td><input type="checkbox" value="roadworthy" name="roadworthy"></td></tr>
            <tr><td></td><td><input type="submit" value="Submit"></td></tr>
        </table>
        </form>
    </body>
</html>
