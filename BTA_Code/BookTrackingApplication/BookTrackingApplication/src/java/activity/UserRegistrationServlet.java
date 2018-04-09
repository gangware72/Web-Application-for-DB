/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 108
 */
public class UserRegistrationServlet extends HttpServlet {

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

//        Map params = request.getParameterMap();
//        Iterator i = params.keySet().iterator();
//        while (i.hasNext()) {
//            String key = (String) i.next();
//            String value = ((String[]) params.get(key))[ 0];
//            System.out.println("<br />key : " + key + " value : " + value);
//        }
        try {
            JDBC dbfunc = new JDBC();
            dbfunc.createConnection();

            String tableName = "users";

            String idnumber = request.getParameter("idnumber");
            String fullname = request.getParameter("fullname");
            String password1 = request.getParameter("password");
            String password2 = request.getParameter("cpassword");
            String grade = request.getParameter("grade");            
            String usertype = request.getParameter("usertype");

            redirect = request.getParameter("redirect");

            if (!password1.trim().equals(password2.trim())) {
                response.sendRedirect(redirect + "Registration Failed : Password Mismatch");
            }

            String query = "INSERT INTO " + tableName.trim() + "(  `idnumber` ,\n"
                    + "  `fullname`,\n"
                    + "  `password`,\n"
                    + "  `grade`,\n"                    
                    + " `usertype`) VALUES ('" + idnumber.trim() + "','" + fullname.trim() + "','" + password1.trim() + "'," + grade.trim() + ",'" + usertype.trim() + "')";

            System.out.println("Query : " + query);
            
            String secq = request.getParameter("secq");
            String seca = request.getParameter("seca");
            String key = idnumber.trim();
            String pass = password1.trim();

            if (dbfunc.updateRecord(query)) {
                response.sendRedirect(redirect + "Registration Success");
            } else {
                response.sendRedirect(redirect + "Registration Failed");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(redirect + "Registration Failed : " + ex.toString());
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
