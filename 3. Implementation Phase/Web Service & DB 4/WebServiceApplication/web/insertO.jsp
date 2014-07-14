<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.*,java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="connectionHeader.jsp" %> 




<sql:query var="getID" dataSource="${dataSource}">
    
    SELECT MAX(owner_id) FROM owner;
</sql:query>
    
    <c:forEach var="row" items="${getID.rowsByIndex}">
        
        <c:forEach var="column" items="${row}">
            <c:set var="returnedID" scope="session" value="${column}"/>
           
        </c:forEach>
        
    </c:forEach>
    <c:set var="IncrementedID" scope="session" value="${returnedID + 1}"/>
         
         
    <sql:update var="owner" dataSource="${dataSource}">
   
    INSERT INTO owner 
    VALUES (?,'<%=request.getParameter("name")%>', '<%=request.getParameter("type")%>', '<%=request.getParameter("addr")%>', '<%=request.getParameter("reg")%>')
     <sql:param value="${IncrementedID}" />
    </sql:update>
    <%
            out.write("<script type='text/javascript'>\n");
            out.write("alert(' Owner Successfully inserted! ');\n");
            out.write("setTimeout(function(){window.location.href='insertion.jsp'},1000);");
            out.write("</script>\n");
    %>
    
