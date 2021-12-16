<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="doktor.doktor"%>
<%@page import="hasta.hasta"%>
<%@page import="doktor.dbDoktorYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page import="randevu.randevu"%>
<%@page import="randevu.dbRandevuYonetim"%>
<%@page import="java.util.List"%>


<%
    dbRandevuYonetim randevuOlustur = new dbRandevuYonetim(dbConnect.getConnection());
    List<randevu> randevular = randevuOlustur.randevuGetirDoktor();
    request.setAttribute("randevular", randevular);
   
    doktor doktor = (doktor) session.getAttribute("loginDoctor");
    
    
%>

<!DOCTYPE html>
<html>
    <head>
       
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Doktor Girişi</title>

        <style>
            #randevu {
border-collapse: collapse;
width: 100%;
}
 
#randevu td, #randevu th {
border: 1px solid #ddd;
padding: 8px;
}
 
#randevu tr:nth-child(even){background-color: #f2f2f2;}
 
#randevu tr:hover {
background-color: #2ecc71;
color:#fff;
}
button{
    background-color: beige; 
    position: absolute;
    right: 100px;
    top: 20px;
    color: white;
    width: 100px;
    height: 30px;
}
.p{
    position: absolute;
    right: 700px;
    top: 1px;
    color: black;
    
}
#randevu th {
padding-top: 12px;
padding-bottom: 12px;
text-align: left;
background-color: #2c3e50;
color: white;
}
        </style>
    </head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
         <link href="https://fonts.googleapis.com/css?family=Montserrat:100,300" rel="stylesheet">
       
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
                     
<div class="col-md-9">
                 <h3> Hoşgeldiniz Sayın <%=doktor.getName()%> </h3>
                  <h3 class="p">Sizden Randevu Alan Hastalara Ait Bilgiler</h3>
<table class="table" id="randevu">
                            <thead class="bg-light">
<tr>
   <th >TC NO</th>
    <th >Ad Soyad</th>
  <th>Poliklinik</th>
  <th>Tarih</th>
 <th>İlaç Düzenle</th>
 
  
   </tr>
</thead>
                <tbody>
        <c:forEach items="${randevular}" var="u">
<tr>
    
                                   <td>${u.getTcNumber()}   </td>
                                    <td>${u.getName()}  </td>
                                   <td>${u.getDepartment()}   </td>
                                   <td>${u.getDate()}</td>
                              <td><a href="ilacDuzenle.jsp?TCNO=${u.getTcNumber()}">Detaylı Bilgiler</a> 
                                </td>
                                    </tr>
</c:forEach>
                            </tbody>
                        </table>
</div>
</div>
</div>
</div> <br>

   
     <button ><a href="doktorCikisServlet">Çıkış Yap</a></button>
    
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>
  

    
    
    
    
   
</body>
</html>
