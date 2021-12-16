/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasta;

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
public class hastaGirisServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hastaGirisServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
             
            String tc = request.getParameter("tcNumber");
            String parola = request.getParameter("password");
            String remember=request.getParameter("remember");
            
           
           if(remember!=null){
              Cookie c = new Cookie("userTc", tc);
              c.setMaxAge(24*60*60);
              response.addCookie(c);
              /**/
              Cookie c1 = new Cookie("userPass", parola);
              c1.setMaxAge(24*60*60);
              response.addCookie(c1);
              
             }
           
             dbHastaYonetim hastaGirisDb = new dbHastaYonetim(dbConnect.getConnection());
             hasta hastaModel =  hastaGirisDb.login(tc,parola);
             if(hastaModel!=null){
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", hastaModel);
                response.sendRedirect("welcomeHasta.jsp");
            }else{
     out.println("BÖYLE BİR HASTA KAYDI BULUNAMADI");
   out.println("<br><br><button><a href=\"hastaGirisEkrani.jsp\">TEKRAR DENE</a> </button>");
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
