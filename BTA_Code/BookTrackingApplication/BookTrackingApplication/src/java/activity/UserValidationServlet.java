/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 108
 */
public class UserValidationServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String redirect = "";

        try {
            String username = request.getParameter("idnumber");
            String password = request.getParameter("password");
            String usertype = request.getParameter("usertype");
            
            
            redirect = request.getParameter("redirect");

            JDBC jdbc = new JDBC();
            jdbc.createConnection();

            String tableName = "users";

            String query = "select * from " + tableName.trim() + " where idnumber='" + username.trim() + "' and password='" + password.trim() + "'";
            System.out.println(query);
            ResultSet rsett = jdbc.queryRecord(query);
System.out.println(usertype);

            if (rsett.next()) {
                
                if (rsett.getString("usertype").trim().equals(usertype) && usertype.equals("admin")) {
                    //Obtain the session object, create a new session if doesn't exist
                    HttpSession session = request.getSession(true);
                    session.setAttribute("idnumber", rsett.getString("idnumber").trim());                    
                    session.setAttribute("usertype", rsett.getString("usertype").trim());                    
                    session.setMaxInactiveInterval(600);                                        
                    response.sendRedirect("admin.jsp");                    
                    return;
                }
                else if ((usertype.equals("faculty"))) {
                    //Obtain the session object, create a new session if doesn't exist
                    HttpSession session = request.getSession(true);
                    session.setAttribute("idnumber", rsett.getString("idnumber").trim());                    
                    session.setAttribute("usertype", rsett.getString("usertype").trim());                    
                    session.setAttribute("grade", rsett.getString("grade").trim());                    
                    session.setMaxInactiveInterval(600);                                        
                    response.sendRedirect(rsett.getString("usertype").trim()+".jsp");                    
                    return;
                }                
                else if (rsett.getString("usertype").trim().equals(usertype) && usertype.equals("student")) {
                    //Obtain the session object, create a new session if doesn't exist
                    HttpSession session = request.getSession(true);
                    session.setAttribute("idnumber", rsett.getString("idnumber").trim());                    
                    session.setAttribute("usertype", rsett.getString("usertype").trim());                    
                    session.setAttribute("grade", rsett.getString("grade").trim());                    
                    session.setMaxInactiveInterval(600);                                        
                    response.sendRedirect("student.jsp");                    
                    return;
                }
                else
                {
                    response.sendRedirect(redirect+"<br><b>Valid user id. But Invalid Usertype.");
                    return;
                }
            } else {
                response.sendRedirect(redirect+"<br><b>Invalid user id. Plz Register.");
                return;
            }
        } catch (Exception ex) {
            System.out.println("Login Exception : " + ex.toString());
        } finally {
            out.close();
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
