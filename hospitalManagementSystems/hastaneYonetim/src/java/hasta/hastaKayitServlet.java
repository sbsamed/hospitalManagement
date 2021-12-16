package hasta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class hastaKayitServlet extends HttpServlet {


        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String tc = request.getParameter("tcNumber");
             String ad = request.getParameter("name");
            String soyad = request.getParameter("surName");
             String yas = request.getParameter("age");
             String telefon = request.getParameter("telephone");
              String parola = request.getParameter("password");
             
              hasta hastaModel = new hasta(tc, ad, soyad,yas,telefon,parola);
              dbHastaYonetim hastaKayıtDb = new dbHastaYonetim(dbConnect.getConnection());
            if (hastaKayıtDb.hastaKayit(hastaModel)) {
            response.sendRedirect("index.html");
        } else {
        String errorMessage = "KAYIT BAŞARISIZ TEKRAR DENEYİNİZ";
        HttpSession regSession = request.getSession();
        regSession.setAttribute("RegError", errorMessage);
        response.sendRedirect("index.html");
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
