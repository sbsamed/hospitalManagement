<%-- 
    Document   : doktorDuzenle
    Created on : 14 Ara 2021, 16:03:11
    Author     : Samed
--%>

<%@page import="hasta.hasta"%>
<%@page import="hasta.dbHastaYonetim"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hasta.dbConnect"%>
<%
    String tc;
    tc=request.getParameter("TCNO");
    dbHastaYonetim hastaDuzenle = new dbHastaYonetim(dbConnect.getConnection());
    hasta hasta = hastaDuzenle.hastaBilgiGetir(tc);
    request.setAttribute("hasta",hasta);
   
    
%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title> Bilgileriniz </title>
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
                        <h3> Bilgileriniz</h3>
                        
        <form action="hastaDuzenleServlet" method="post">
                    <div class="form-group">
                  
      <div class="form-group"> 
          TC No:
          <input type="text" class="form-control" value="${hasta.tcNumber}" disabled name="tc">
                </div> 
          <div class="form-group">  
              İsim:
  <input type="text" class="form-control"  value="${hasta.name}" name="name" disabled >
        </div>
           <div class="form-group">   
               Soyisim:
  <input type="text" class="form-control"  value="${hasta.surName}" name="surName" disabled >
        </div>
         <div class="form-group">
             Yaş
   <input type="text" class="form-control"  value="${hasta.age}" name="age" disabled >
          </div>
          <div class="form-group">
              İletişim:
   <input type="text" class="form-control"  value="${hasta.telephone}" name="telephone" disabled >
          </div>
          <div class="form-group">
              Parolanız:
   <input type="text" class="form-control"  value="${hasta.password}" name="password" disabled >
          </div>
         
        </form>

<button  class="btn btn-primary"> <a href="welcomeHasta.jsp"> Geri Dön</a> </button>
                   
</div>
</div>
</div>
</div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>

