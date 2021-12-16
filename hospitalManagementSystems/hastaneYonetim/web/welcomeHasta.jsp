<%@page import="hasta.hasta"%>
<%@page import="randevu.randevu"%>
<%@page import="randevu.dbRandevuYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! static hasta hasta=null; %>
<%
    dbRandevuYonetim randevuOlustur = new dbRandevuYonetim(dbConnect.getConnection());
    List<randevu> randevular = randevuOlustur.randevuGetir();
    request.setAttribute("randevular", randevular);
    hasta = (hasta) session.getAttribute("loginUser");
    String date="";
     String bolum="";
    Cookie[] cookies = request.getCookies();
if(cookies.length>0){
    for(int i=0;i<cookies.length;i++)
{ 
    Cookie c3 = cookies[i];
    if (c3.getName().equals("randevuDate"))
    {
        date= c3.getValue();
        System.out.println(date);
        
    }
   }  
}
     
%>



<!DOCTYPE html>
<html>
    <head>
       
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

     <title>Hasta Girişi</title>

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
Randevu Oluştur</h3>
<form action="randevuEkleServlet" method="post">
    <div class="form-group">
            <label>Tc No</label>
         <input class="form-control" disabled name="tcNumber" value="<%= hasta.getTcNumber() %>">
               </div>
             <div class="form-group">
            <label>Ad Soyad</label>
   <input class="form-control" name="nameSurname" disabled value="<%= hasta.getName()+" "+hasta.getSurName()%>">
                    </div>
<div class="form-group">
              <label>Tarih</label>
              <input type="date"class="form-control" name="date"  value="<%=date%>" required>
                    </div>

<div class="form-group" >
          <label>Poliklinik</label>
             <select id="inputState" class="form-control" name="department" required>
          <option  value="KalpHastaliklari">Kalp Hastalıkları</option>
          <option value="Dermatoloji">Dermatoloji</option>
       <option value="KulakBurunBogaz">Kulak Burun Bogaz</option>
        <option value="FizikTedavi">Fizik Tedavi</option>
       </select>
      </div>
    <button type="submit" class="btn btn-primary">Randevu Oluştur</button><br><br>
  <button style="background: aqua"> <a href="ilacGoruntule.jsp?TCNO=<%=hasta.getTcNumber()%>">İlaçlarımı Göster</a></button>
  <br><br>
   <button style="background: aqua">  <a href="hastaBilgileri.jsp?TCNO=<%=hasta.getTcNumber()%>">Bilgilerim</a> </button><br><br>
  <button style="background: aqua"> <a href="hastaCikisServlet">Çıkış Yap</a></button>

     </form>
</div>
<div class="col-md-9">
           <h3>
        Randevularınız</h3>
<table class="table">
           <thead class="bg-light">
<tr>
  <th scope="col">Poliklinik</th>
  <th scope="col">Tarih</th>
   </tr>
</thead>
                <tbody>
        <c:forEach items="${randevular}" var="u">
<tr>
                     <td>${u.getDepartment()}</td>
                      <td>${u.getDate()}</td>
                      <td><a href="randevuDuzenle.jsp?Tarih=${u.getDate()}">Düzenle</a> -
                    <a href="randevuSilServlet?Tarih=${u.getDate()}">Sil</a>
                   
                      </td>
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

