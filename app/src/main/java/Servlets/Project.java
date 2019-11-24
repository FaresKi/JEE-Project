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
        session.setAttribute("errorAdd", false);
        session.setAttribute("emplSelected", true);
        session.setAttribute("emplDeleted", false);

        // Login
        if (userName != null) {
            User loggedUser = connection.getUser(userName, password);
            if (loggedUser == null){
                String errorConnection = "errorConnection";
                session.setAttribute("errorConnection", errorConnection);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if (loggedUser.getClass() == AdminUser.class){
                    AdminUser admin = (AdminUser) loggedUser;
                    session.setAttribute("admin", admin);
                    session.setAttribute("errorConnection", "");
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    session.setAttribute("user", loggedUser);
                    session.setAttribute("errorConnection", "");
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            }
        }

        // Redirection des boutons Ajouter/Modfier/Supprimer
        String action = request.getParameter("action");
        if (action != null && session.getAttribute("admin") != null){
            switch (action) {
                case "Ajouter":
                    session.setAttribute("action", action);
                    request.getRequestDispatcher("add.jsp").include(request, response);
                    break;
                
                case "Modifier":
                    if (request.getParameter("idEmpl") == null){
                        session.setAttribute("emplSelected", false);
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    } else {
                        Integer idEmpl = Integer.parseInt(request.getParameter("idEmpl"));
                        Employee changedEmp = connection.getSpecificEmployee(idEmpl);
                        session.setAttribute("changedEmp", changedEmp);
                        session.setAttribute("idEmpl", idEmpl);
                        session.setAttribute("action", action);
                        session.setAttribute("emplSelected", true);
                        request.getRequestDispatcher("modify.jsp").forward(request, response);
                    }
                    break;

                case "Supprimer":
                    if (request.getParameter("idEmpl") == null){
                        session.setAttribute("emplSelected", false);
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    } else {
                        Integer idEmpl = Integer.parseInt(request.getParameter("idEmpl"));
                        connection.deleteEmployee(idEmpl);
                        list = connection.getAllEmployees();
                        session.setAttribute("listEmp", list);
                        session.setAttribute("emplSelected", true);
                        session.setAttribute("emplDeleted", true);
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    }
            }
        } 

        // Gestion des actions dans les jsp add et modify
        action = (String) session.getAttribute("action");
        if (action != null && session.getAttribute("admin") !=null){
            switch (action) {
                case "Ajouter":
                    if (request.getParameter("retour") != null) 
                        response.sendRedirect("admin.jsp");
                    if (request.getParameter("add") != null){
                        String addNom = (String) request.getParameter("addNom");
                        String addPrenom = (String) request.getParameter("addPrenom");
                        String addTeldom = (String) request.getParameter("addTeldom");
                        String addTelport = (String) request.getParameter("addTelport");
                        String addTelpro = (String) request.getParameter("addTelpro");
                        String addAdresse = (String) request.getParameter("addAdresse");
                        String addCodePostal = (String) request.getParameter("addCodePostal");
                        String addVille = (String) request.getParameter("addVille");
                        String addEmail = (String) request.getParameter("addEmail");
                        try {
                            connection.addNewEmployee(addNom, addPrenom, addTeldom, addTelport, addTelpro, addAdresse, addCodePostal, addVille, addEmail);
                        } catch (Exception e) {
                            session.setAttribute("errorAdd", true);
                            request.getRequestDispatcher("add.jsp").forward(request, response);
                        }
                        list = connection.getAllEmployees();
                        session.setAttribute("listEmp", list);
                        session.setAttribute("errorAdd", false);
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    }

                    break;
                
                case "Modifier":
                    if (request.getParameter("retour") != null) 
                        response.sendRedirect("admin.jsp");
                    if (request.getParameter("modify") != null){
                        String modifiedNom = (String) request.getParameter("modifiedNom");
                        String modifiedPrenom = (String) request.getParameter("modifiedPrenom");
                        String modifiedTeldom = (String) request.getParameter("modifiedTeldom");
                        String modifiedTelport = (String) request.getParameter("modifiedTelPortable");
                        String modifiedTelpro = (String) request.getParameter("modifiedTelPro");
                        String modifiedAdresse = (String) request.getParameter("modifiedAdresse");
                        String modifedCodePostal = (String) request.getParameter("modifiedCodePostal");
                        String modifiedVille = (String) request.getParameter("modifiedVille");
                        String modifiedEmail = (String) request.getParameter("modifiedEmail");

                        Integer idEmpl = (Integer) session.getAttribute("idEmpl");
                        connection.updateEmployee(idEmpl, modifiedNom, modifiedPrenom, modifiedTeldom, modifiedTelport, modifiedTelpro, modifiedAdresse, modifedCodePostal, modifiedVille, modifiedEmail);
                        list = connection.getAllEmployees();
                        session.setAttribute("listEmp", list);
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    }
                    break;
            }
        }

        // Deconnexion
        if (request.getParameter("logout") != null) {
            session.invalidate();
            response.sendRedirect("logout.html");
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
            Logger.getLogger(Project.class
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
            Logger.getLogger(Project.class
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
