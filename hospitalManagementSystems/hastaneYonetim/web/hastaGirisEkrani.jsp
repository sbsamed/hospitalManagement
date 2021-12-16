<%@page import="hasta.hasta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String userId="";
    String userpass="";
    String checked="";
    Cookie[] cookies = request.getCookies();     
    Cookie[] cookies2 = request.getCookies();                              
  if(cookies2.length>0){
    for(int i=0;i<cookies.length;i++){ 
    Cookie c = cookies[i];
    Cookie c2 = cookies2[i];
    if (c.getName().equals("userTc")) {
        userId= c.getValue();
        checked = "checked";
    }
    if (c2.getName().equals("userPass")  ){
        userpass=c2.getValue();
        checked = "checked";
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

        <title>Hasta Giriş Ekranı</title>
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
                        <h3>Hasta Giriş Ekranı</h3>
                        
     <form action="hastaGirisServlet" method="post">
                    <div class="form-group">     
      <div class="form-group"> 
          TC No:
<input type="text" class="form-control" name="tcNumber" value="<%=userId%>">
                </div>
          <div class="form-group">
              Şifre
   <input type="password" class="form-control"  name="password"   value="<%=userpass%>" >
          </div>
        
   <input type="checkbox" name="remember" <%=checked%> /> Beni Hatırla  <br> <br>
         
         
<button type="submit" class="btn btn-primary">Giriş Yap</button>

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