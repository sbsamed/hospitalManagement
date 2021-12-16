<%@page import="randevu.randevu"%>
<%@page import="randevu.dbRandevuYonetim"%>
<%@page import="hasta.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String tarih = request.getParameter("Tarih");
    dbRandevuYonetim randevu = new dbRandevuYonetim(dbConnect.getConnection());
    randevu rnd = randevu.randevuDuzenle(tarih);
    request.setAttribute("rnd", rnd);
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

       
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Randevu Düzenle</title>
        <style>
            .inner{
                position: relative;
                margin: 0 auto;
                width: 650px;
                display: block;
                padding: 50px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
       <div  class="container-fluid">
            <nav class="navbar navbar-light">
               
                <ul class="navbar-nav ml-auto mt-3 mx-5">
<li class="nav-item">
                           
                        </li>
</ul>
</nav>
        </div>
<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3>
Randevunuzun Detayları</h3>
<form action="randevuDuzenleServlet" method="post">
                            <div class="form-group">
                   <label>Tarih</label>
                    <input type="date" class="form-control"  value="${rnd.getDate()}" name="date"  >
                            </div>

<div class="form-group" >
  
  <label>Poliklinik</label>
             <select id="inputState" class="form-control" name="poliklinik" required>
         
               <option value="KalpHastaliklari">Kalp Hastaliklari</option>
                  <option value="Dermatoloji">Dermatoloji</option>
                      <option value="KulakBurunBogaz">KulakBurunBogaz</option>
                       <option value="FizikTedavi">Fizik Tedavi</option>
                         </select>
                            </div>
<button type="submit" class="btn btn-primary">Kaydet</button>
 <button  class="btn btn-primary"><a href="welcomeHasta.jsp">Geri Dön</a></button>                
                        </form>

</div>
</div>
</div>
</div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>
