/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stokedpenguin.webapp;

import com.stokedpenguin.webapp.db.Database;
import com.stokedpenguin.webapp.db.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * On GET request, servlet renders login form.
 * On POST, credentials are verified and status rendered.
 * @author don
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>StokedPenguin Login</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login</h1>");
        out.println("<form method='POST'>");
        out.println("Username: <input name='username' type='text'/><br/>");
        out.println("Password: <input name='password' type='password'/><br/>");
        out.println("<input type='submit'/><br/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>StokedPenguin Login</title>");            
        out.println("</head>");
        out.println("<body>");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        try {
            Database db = (Database)request.getServletContext().
                getAttribute(ContextListener.attrDatabase);
            user = User.fromUsernamePassword(username, password, db.getConnection());
            if (user != null) {
                HttpSession sess = request.getSession();
                sess.setAttribute("user", user);
            }
        } catch (Throwable e) {
            System.err.println("OOPS: " + e);
        }

        if (user != null) {
            out.println("<h1>Logged in as "+user.getUsername()+"</h1>");
            out.println("<a href='home'>Home</a>");
        } else {
            out.println("<h1>Invalid Login</h1>");
            out.println("You must <a href='login'>Login</a>");
        }
        
        out.println("</body>");
        out.println("</html>");
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
