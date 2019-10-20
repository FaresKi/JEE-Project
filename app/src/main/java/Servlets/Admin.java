/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import JavaBeans.Employee;
import Utilities.ConnectionClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fareskissoum Servlet pour afficher la liste des employés
 */
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/admin.jsp");
        if (request.getSession().getAttribute("admin") != null) {
            ConnectionClass connection;
            try {
                connection = new ConnectionClass();
                List<Employee> list = connection.getAllEmployees();
                HttpSession session = request.getSession();
                session.setAttribute("list", list);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            requestDispatcher.include(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
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
        request.getServletContext().getRequestDispatcher("/admin.jsp");

        String delete = request.getParameter("delete");
        String modify = request.getParameter("modify");

        if (request.getParameter("add") != null) {
            response.sendRedirect(request.getContextPath() + "/add");
        }

        if (request.getParameter("delete") != null) {
            ConnectionClass connection;
            try {
                connection = new ConnectionClass();
                String select = (String) request.getParameter("select");
                System.out.println("Select : " + select);
                connection.deleteEmployee(select);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect(request.getContextPath() + "/admin");
        }

        if (request.getParameter("modify") != null) {
            ConnectionClass connection;
            try {
                connection = new ConnectionClass();
                String select = (String) request.getParameter("select");
                Employee changedEmp = connection.getSpecificEmployee(select);
                request.getSession().setAttribute("changedEmp",changedEmp);
                request.getSession().setAttribute("select", select);
                response.sendRedirect(request.getContextPath() + "/modify");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
