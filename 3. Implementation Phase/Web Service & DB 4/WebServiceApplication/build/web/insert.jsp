<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.*,java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="connectionHeader.jsp" %> 


<c:set var="getID2" value="${0}"/>

<sql:query var="getID" dataSource="${dataSource}">
    
    SELECT MAX(owner_id) FROM owner;
</sql:query>
    
    <c:if test="${getID} == ''">
        <c:set var="getID2" value="${0}"/>
        <sql:update var="owner" dataSource="${dataSource}">
   
            INSERT INTO owner 
            VALUES (<sql:param value="${getID2 +1}" />+1,'<%=request.getParameter("name")%>', '<%=request.getParameter("type")%>', '<%=request.getParameter("addr")%>', '<%=request.getParameter("reg")%>')

        </sql:update>
    </c:if>
   <fmt:parseNumber var="i" type="number" value="${getID}" /> 
<sql:update var="owner" dataSource="${dataSource}">
   
    INSERT INTO owner 
    VALUES (<sql:param value="${getID +1}" />+1,'<%=request.getParameter("name")%>', '<%=request.getParameter("type")%>', '<%=request.getParameter("addr")%>', '<%=request.getParameter("reg")%>')
     
</sql:update>