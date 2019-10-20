/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Utilities.ConnectionClass;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fareskissoum
 */
@WebServlet(urlPatterns = {"/add"})
public class Add extends HttpServlet {
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
        request.getRequestDispatcher("/add.jsp").include(request, response);

        String nom = (String) request.getParameter("nom");
        String prenom = (String) request.getParameter("prenom");
        String teldom = (String) request.getParameter("teldom");
        String telport = (String) request.getParameter("telport");
        String telpro = (String) request.getParameter("telpro");
        String adresse = (String) request.getParameter("adresse");
        String codePostal = (String) request.getParameter("codepostal");
        String ville = (String) request.getParameter("ville");
        String email = (String) request.getParameter("email");

        if (nom != null) {
            try {
                ConnectionClass connection = new ConnectionClass();
                connection.addNewEmployee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
                response.sendRedirect(request.getContextPath() + "/admin");
            } catch (SQLException ex) {
                System.out.println("exception sql");
            } catch (ClassNotFoundException ex) {
                System.out.println("exception class");
            }
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
