<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.*,java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="connectionHeader.jsp" %> 




    <sql:query var="getFeatureID" dataSource="${dataSource}">

        SELECT MAX(feature_id) FROM vehiclefeatures;
    </sql:query>

    <c:forEach var="row" items="${getFeatureID.rowsByIndex}">

        <c:forEach var="column" items="${row}">
            <c:set var="returnedFeatureID" scope="session" value="${column}"/>

        </c:forEach>

    </c:forEach>
    <c:set var="IncrementedFeatureID" scope="session" value="${returnedFeatureID + 1}"/>
    
    
    <!-- 
        #This query inserts a feature object 
    -->
    
     <sql:update var="insertFeature" dataSource="${dataSource}">
            INSERT INTO vehiclefeatures values (?, '<%=request.getParameter("make")%>', '<%=request.getParameter("type")%>', '<%=request.getParameter("model")%>', '<%=request.getParameter("colour")%>')
            <sql:param value="${IncrementedFeatureID}" />


     </sql:update>
    
    <!--
        # This part fetches the Owner ID or get number
        # to verify that the vehicle's owner exists.
        # The ID is attached to a variable then passed to 
        # and insert query for the vehicle
    --> 
    
    <sql:query var="getOwnerID" dataSource="${dataSource}">
        SELECT owner_id FROM owner WHERE id_or_reg_number = '<%=request.getParameter("owner")%>'
    </sql:query>
        
    <c:forEach var="row" items="${getOwnerID.rowsByIndex}">

        <c:forEach var="column" items="${row}">
            <c:set var="returnedOwnerID" scope="session" value="${column}"/>
        </c:forEach>

    </c:forEach>    
        
    <!-- 
        #This part generates a vehicle id before inserting
        #by finding the highest id used then increment it.
    -->
    <sql:query var="getVehicleID" dataSource="${dataSource}">

        SELECT MAX(vehicle_id) FROM vehicle;
    </sql:query>

    <c:forEach var="row" items="${getVehicleID.rowsByIndex}">

        <c:forEach var="column" items="${row}">
            <c:set var="returnedVehicleID" scope="session" value="${column}"/>

        </c:forEach>

    </c:forEach>
    <c:set var="IncrementedVehicleID" scope="session" value="${returnedVehicleID + 1}"/>    
        
     <!-- 
        #This part fecthes the current feature id that matches 
        #the entered features.
    -->
    
      
    
    
    <sql:update var="owner" dataSource="${dataSource}">
   
        INSERT INTO vehicle 
        VALUES (?,'<%=request.getParameter("plate")%>', ?, ?,'<%=request.getParameter("stolen")%>', '<%=request.getParameter("fines")%>', '<%=request.getParameter("roadworthy")%>')
        <sql:param value="${IncrementedVehicleID}" />
        <sql:param value="${returnedOwnerID}" />
        <sql:param value="${IncrementedFeatureID}" />
        
    </sql:update>
    <%
            out.write("<script type='text/javascript'>\n");
            out.write("alert(' Vehicle Successfully inserted! ');\n");
            out.write("setTimeout(function(){window.location.href='insertion.jsp'},1000);");
            out.write("</script>\n");
    %>
    
