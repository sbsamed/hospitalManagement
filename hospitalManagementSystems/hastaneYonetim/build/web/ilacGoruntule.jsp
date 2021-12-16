<%-- 
    Document   : welcomeYonetici
    Created on : 13 Ara 2021, 17:51:32
    Author     : Samed
--%>
<%@page import="java.util.List"%>
<%@page import="ilac.ilac"%>
<%@page import="ilac.dbIlacYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String tc=request.getParameter("TCNO");
    dbIlacYonetim hastaIlac = new dbIlacYonetim(dbConnect.getConnection());
     List<ilac> ilc =hastaIlac.hastaIlacBilgileri(tc);
    request.setAttribute("ilc",ilc);
   
%>
<!DOCTYPE html>
<html>
<head>
<style>
    body{
        background-color: azure;
    }
    div.tablo{
        overflow-x: auto;
    }
    table {
        position: absolute;
        top: 50px;
        left:480px;
        border-collapse: collapse;
        width: 40%;
    }
 
    th, td {
        text-align: left;
        padding: 8px;
    }
 
    tr:nth-child(even){
        background-color: #f2f2f2;
    }
     tr:nth-child(odd){
        background-color: lemonchiffon;
    }
 
    th {
        background-color: forestgreen;
        color: white;
    }
    .p{
    position: absolute;
    right: 700px;
    top: 1px;
    color: black;
    
}
.b1{
    background-color: aqua; 
    position: absolute;
    right: 200px;
    top: 50px;
    color: white;
    width: 140px;
    height: 30px;
}

</style>
</head>
<body>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div >
    
    
    <h2 class="p">Kullandığınız İlaçlar </h2>
    <table>
      <tr><th>İLACI VEREN BÖLÜM</th>
        <th>İLAÇ</th></tr>
      <c:forEach items="${ilc}" var="u">
<tr>
                <td>${u.getDeparment()}</td>
               <td>${u.getIlac()}</td>
           </tr>
                                    
                                   
</c:forEach>
    </table>
</div>
    <button class="b1"><a href="welcomeHasta.jsp">Geri Dön</a></button>
</body>
</html>