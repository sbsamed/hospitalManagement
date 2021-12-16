
package ilac;

import doktor.dbDoktorYonetim;
import hasta.dbConnect;
import hasta.dbHastaYonetim;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Samed
 */
public class ilacEkleServlet extends HttpServlet {

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
            out.println("<title>Servlet ilacEkleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
   
    
         dbDoktorYonetim bolum = new dbDoktorYonetim();
         dbHastaYonetim hastaBilgi=new dbHastaYonetim();
        String newilac = request.getParameter("newIlac");
            try{
                
            dbIlacYonetim x = new dbIlacYonetim(dbConnect.getConnection());
             x.ilacEkle((x.hastaTc),(hastaBilgi.hastaAdSoyad),(bolum.doktorBolum),(newilac));
             response.sendRedirect("welcomeDoktor.jsp");
              
            }catch(Exception e){
     out.println("KAYIT EKLENEMEDİ");
   out.println("<br><br><button><a href=\"welcomeDoktor.jsp\">TEKRAR DENE</a> </button>");
                e.printStackTrace();
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
