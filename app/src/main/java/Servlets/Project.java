/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import JavaBeans.AdminUser;
import JavaBeans.Employee;
import JavaBeans.User;
import Utilities.ConnectionClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
 * @author fareskissoum
 */
@WebServlet(urlPatterns = {"/Project"})

public class Project extends HttpServlet {

    HttpSession session;
    ConnectionClass connection;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        connection = new ConnectionClass();
        session = request.getSession();
        List<Employee> list = connection.getAllEmployees();
        session.setAttribute("listEmp", list);
        if (userName != null) {
            if (connection.getUser(userName, password).getClass() == AdminUser.class) {
                AdminUser admin = new AdminUser(userName, password);
                session.setAttribute("admin", admin);
                response.sendRedirect("admin.jsp");
            }
            if (connection.getUser(userName, password).getClass() == User.class) {
                User user = new User(userName, password);
                session.setAttribute("user", user);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }

        }

        //Ajout
        //on choppe le Parameter et on fait l'include et on sort du if
        if (request.getParameter("add") != null && session.getAttribute("admin") != null) {
            request.getRequestDispatcher("add.jsp").include(request, response);
        }

        String addNom = (String) request.getParameter("nom");
        String addPrenom = (String) request.getParameter("prenom");
        String addTeldom = (String) request.getParameter("teldom");
        String addTelport = (String) request.getParameter("telport");
        String addTelpro = (String) request.getParameter("telpro");
        String addAdresse = (String) request.getParameter("adresse");
        String addCodePostal = (String) request.getParameter("codepostal");
        String addVille = (String) request.getParameter("ville");
        String addEmail = (String) request.getParameter("email");
        if (addNom != null) {
            System.out.println("dans add 2");
            connection.addNewEmployee(addNom, addPrenom, addTeldom, addTelport, addTelpro, addAdresse, addCodePostal, addVille, addEmail);
            if (request.getParameter("retour") != null && session.getAttribute("admin") != null) {
                response.sendRedirect("admin.jsp");
            } else if (session.getAttribute("admin") != null) {
                response.sendRedirect("admin.jsp");
            }
        }

        //Modification
        
        //on choppe le Parameter et on fait l'include et on sort du if
        
        if (request.getParameter("modify") != null && session.getAttribute("admin") != null) {

            String select = (String) request.getParameter("select");
            Employee changedEmp = connection.getSpecificEmployee(select);
            request.getSession().setAttribute("changedEmp", changedEmp);
            request.getSession().setAttribute("select", select);
            request.getRequestDispatcher("modify.jsp").include(request, response);
        }

        String select = (String) request.getParameter("select");
        Employee changedEmp = connection.getSpecificEmployee(select);

        String modifiedNom = (String) request.getParameter("nom");
        String modifiedPrenom = (String) request.getParameter("prenom");
        String modifiedTeldom = (String) request.getParameter("teldom");
        String modifiedTelport = (String) request.getParameter("telport");
        String modifiedTelpro = (String) request.getParameter("telpro");
        String modifiedAdresse = (String) request.getParameter("adresse");
        String modifedCodePostal = (String) request.getParameter("codepostal");
        String modefiedVille = (String) request.getParameter("ville");
        String modefiedEmail = (String) request.getParameter("email");

        if (modifiedNom != null) {
            if (request.getParameter("retour") != null && session.getAttribute("admin") != null) {
                response.sendRedirect("admin.jsp");
            }
        }

    

    if (request.getParameter ( 
        "logout") != null) {
            if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            response.sendRedirect("login.jsp");

        } else if (session.getAttribute("admin") != null) {
            session.removeAttribute("admin");
            response.sendRedirect("login.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Project

.class  


.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Project

.class  


.getName()).log(Level.SEVERE, null, ex);
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
