/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

import hasta.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Samed
 */
public class doktorGirisServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doktorGirisServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             
          
           
        String tc = request.getParameter("tcNumber");
        String parola = request.getParameter("password");
        String remember=request.getParameter("remember");
            
           if(remember!=null){
           
             Cookie c3 = new Cookie("doktorTc", tc);
             c3.setMaxAge(24*60*60);
             response.addCookie(c3);
             
             Cookie c4 = new Cookie("doktorPass", parola);
             c4.setMaxAge(24*60*60);
             response.addCookie(c4);
              
             
             }  
            
       dbDoktorYonetim doktorGirisDb = new dbDoktorYonetim(dbConnect.getConnection());
       doktor doktorModel =  doktorGirisDb.login(tc, parola);
     
            
          if(doktorModel!=null){
               HttpSession session = request.getSession();
                session.setAttribute("loginDoctor", doktorModel);
                response.sendRedirect("welcomeDoktor.jsp");
               
            }else{
   out.println("Böyle Bir Doktor Kaydı Bulunamadı");
   out.println("<br><br><button><a href=\"doktorGiris.jsp\">TEKRAR DENE</a> </button>");
            }
          
       
            
            
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
