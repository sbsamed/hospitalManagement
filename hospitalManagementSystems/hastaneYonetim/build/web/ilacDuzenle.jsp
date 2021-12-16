<%-- 
    Document   : ilacDuzenle
    Created on : 12 Ara 2021, 21:23:25
    Author     : Samed
--%>

<%@page import="hasta.hasta"%>
<%@page import="hasta.dbHastaYonetim"%>
<%@page import="java.util.List"%>
<%@page import="ilac.ilac"%>
<%@page import="ilac.dbIlacYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String tc ; 
    tc = request.getParameter("TCNO");
    dbIlacYonetim ilacBilgileri = new dbIlacYonetim(dbConnect.getConnection());
    
    List<ilac> ilaclar = ilacBilgileri.ilacGetirDoktor(tc);
    ilacBilgileri.ilacBilgileriGetir(tc);
    request.setAttribute("ilaclar", ilaclar);
    
    dbHastaYonetim hastaBilgileri = new dbHastaYonetim(dbConnect.getConnection());
    hasta hasta=hastaBilgileri.hastaBilgiGetir(tc);
   
     
%>

<!DOCTYPE html>
<html>
    <head>
       
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

     <title>İlaç Bilgileri</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <div  class="container-fluid">
     <nav class="navbar navbar-light">
         <a class="navbar-brand"></a>
    <form class="form-inline">
      
             </form>
</nav>
        </div>
<div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-md-3">
                        <h3>
Hasta İçin İlaç Ekle</h3>
<form action="ilacEkleServlet" method="post">
                            <div class="form-group">
       <label>Ad Soyad</label>
 <input class="form-control" name="nameSurname" disabled value="<%= hasta.getName()+" "+hasta.getSurName()%>">
                            </div>

<div class="form-group">
                                <label>Tc No</label>
     <input class="form-control" disabled name="tcNumber" value="<%=hasta.getTcNumber()%>">
                            </div>
                        
                            <div class="form-group">
                                <label>İlaç</label>
                                <input type="text"class="form-control" name="newIlac"  required>
                            </div>

<button type="submit" class="btn btn-primary">İlaç Ekle</button>

 <button style="background: aqua"> <a href="welcomeDoktor.jsp">Geri Dön</a>
               </button>
                
                <button style="background: aqua"> <a href="doktorCikisServlet">Çıkış Yap</a>
               </button>
                       
                        </form>
</div>
<div class="col-md-9">
                        <h3>
        Hastanın Geçmiş İlaçları</h3>
<table class="table">
                            <thead class="bg-light">
<tr>
    <th scope="col">TC</th>
    <th scope="col">Ad Soyad</th>
  <th scope="col">Poliklinik</th>
  <th scope="col">İlaç</th>
   </tr>
</thead>
                <tbody>
        <c:forEach items="${ilaclar}" var="u">
            
      <td>${u.getTcNumber()}</td>
  <td>${u.getName()}</td>
    <td>${u.getDeparment()}</td>
     <td>${u.getIlac()}</td>
      <td><a href="ilacDuzenle2.jsp?ILAC=${u.getIlac()}">Düzenle </a> 
         <a href="ilacSilServlet?ILAC=${u.getIlac()}"> Sil</a></td>
                               
                                    </tr>
</c:forEach>
                            </tbody>
                        </table>
</div>
</div>
</div>
</div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>


  
















