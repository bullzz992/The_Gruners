<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.*,java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

String name;
<sql:update var="insertOwner" dataSource="">
    INSERT INTO owner (name, type,address,id_or_reg)
    VALUES (value1, value2,....)
</sql:update>

<% 
    if(request.getParameter("name").length()!=0)
    {
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String reg=request.getParameter("reg");
        String address=request.getParameter("addr");
        
        try{
         Class.forName("mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
           Statement st=con.createStatement();
           int i=st.executeUpdate("insert into student(fname,lname,email,pass,cpass,dob,age,gender,address,country,state,city,tno,mobile) values('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+cpass+"','"+dob+"','"+age+"','"+gender+"',"+address+",'"+country+"','"+state+"','"+city+"','"+city+"','"+tno+"','"+mobile+"')");
        out.println("Data is successfully inserted!");
        }
        catch(Exception e){
        System.out.print(e);
        e.printStackTrace();
        }
        
    }






%>
