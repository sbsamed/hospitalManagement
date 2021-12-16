<%-- 
    Document   : randevuOlustur
    Created on : 14 Ara 2021, 18:06:07
    Author     : Samed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Misafir Randevu Ekranı</title>
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

<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3> Misafir Kullanıcılar İçin Randevu Tarihi Seçimi </h3>
                        
     <form action="randevuCookieServlet" method="post">
                    <div class="form-group">     
      <div class="form-group"> 
          Randevu Tarihinizi Seçiniz:
<input type="date" class="form-control" name="dateCookie" >
                </div>
         
            
<button type="submit" class="btn btn-primary">Randevu Oluştur</button>


        </form>      
                        <button  class="btn btn-primary"> <a href="index.html"> Geri Dön</a> </button>
</div>
</div>
</div>
</div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>
