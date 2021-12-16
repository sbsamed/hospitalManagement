<%-- 
    Document   : welcomeYonetici
    Created on : 13 Ara 2021, 17:51:32
    Author     : Samed
--%>
<%@page import="yonetici.yonetici"%>
<%@page import="doktor.doktor"%>
<%@page import="java.util.List"%>
<%@page import="yonetici.dbYoneticiKontrol"%>
<%@page import="doktor.dbDoktorYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    dbDoktorYonetim doktorOlustur = new dbDoktorYonetim(dbConnect.getConnection());
     List<doktor> doktorlar = doktorOlustur.doktorGetirYonetici();
    request.setAttribute("doktorlar",doktorlar);
   
    yonetici yonetici = (yonetici) session.getAttribute("loginYonetici");
    
    
%>
<!DOCTYPE html>
<html>
<head>
<style>
    div.tablo{
        overflow-x: auto;
    }
    table {
        position: absolute;
        top: 50px;
        border-collapse: collapse;
        width: 100%;
    }
 
    th, td {
        text-align: left;
        padding: 8px;
    }
 
    tr:nth-child(even){
        background-color: #f2f2f2;
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
    background-color: beige; 
    position: absolute;
    right: 155px;
    top: 10px;
    color: white;
    width: 140px;
    height: 30px;
}
.b{
    background-color: beige; 
    position: absolute;
    right: 10px;
    top: 10px;
    color: white;
    width: 140px;
    height: 30px;
}
</style>
</head>
<body>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="tablo">
    
    <h3> Hoşgeldiniz Sayın <%=yonetici.getName()%> </h3>
    <h2 class="p"> Hastanedeki Doktorlara Ait Bilgiler</h2>
    <table>
      <tr>
        <th>TCNO</th>
        <th>İSİM</th>
        <th>SOYİSİM</th> 
        <th>BÖLÜM</th>
        <th>İLETİŞİM</th>
       
      </tr>
      <c:forEach items="${doktorlar}" var="u">
<tr>
                                  <td>${u.getTcNumber()}   </td>
                                    <td>${u.getName()}  </td>
                                   <td>${u.getSurname()}   </td>
                                   <td>${u.getDeparmant()}</td>
                                   <td>${u.getTelephone()}</td>
         <td><a href="doktorDuzenle.jsp?TCNO=${u.getTcNumber()}">Düzenle</a> 
             -
         <a href="doktorSilServlet?TCNO=${u.getTcNumber()}">Sil</a>               
         
         </td>
                                    </tr>
                                    
                                   
</c:forEach>
      
    </table>
</div>
 
           <button class="b"><a href="yoneticiCikisServlet">Çıkış Yap</a></button>
           <button class="b1"><a href="doktorEkle.jsp">Yeni Doktor Ekle</a></button>
</body>
</html>