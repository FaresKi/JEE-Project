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
                request.getRequestDispatcher("admin.jsp").forward(request, response);

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

        String addNom = (String) request.getParameter("addNom");
        String addPrenom = (String) request.getParameter("addPrenom");
        String addTeldom = (String) request.getParameter("addTeldom");
        String addTelport = (String) request.getParameter("addTelport");
        String addTelpro = (String) request.getParameter("addTelpro");
        String addAdresse = (String) request.getParameter("addAdresse");
        String addCodePostal = (String) request.getParameter("addCodePostal");
        String addVille = (String) request.getParameter("addVille");
        String addEmail = (String) request.getParameter("addEmail");
        if (addNom != null && request.getParameter("modify") == null) {
            System.out.println("dans add 2");
            connection.addNewEmployee(addNom, addPrenom, addTeldom, addTelport, addTelpro, addAdresse, addCodePostal, addVille, addEmail);
            if (request.getParameter("retour") != null && session.getAttribute("admin") != null) {
                response.sendRedirect("admin.jsp");
            } else if (session.getAttribute("admin") != null) {
                list = connection.getAllEmployees();
                session.setAttribute("listEmp", list);
                response.sendRedirect("admin.jsp");
            }
        }

        request.removeAttribute("add");
        //Modification
        //on choppe le Parameter et on fait l'include et on sort du if
        if (request.getParameter("modify") != null && session.getAttribute("admin") != null) {

            System.out.println("dans modify");
            Integer select = Integer.parseInt(request.getParameter("select"));
            Employee changedEmp = connection.getSpecificEmployee(select);
            request.getSession().setAttribute("changedEmp", changedEmp);
            request.getSession().setAttribute("select", select);
            request.getRequestDispatcher("modify.jsp").forward(request, response);
        }
        String modifiedNom = (String) request.getParameter("modifiedNom");
        String modifiedPrenom = (String) request.getParameter("modifiedPrenom");
        String modifiedTeldom = (String) request.getParameter("modifiedTeldom");
        String modifiedTelport = (String) request.getParameter("modifiedTelPortable");
        String modifiedTelpro = (String) request.getParameter("modifiedTelPro");
        String modifiedAdresse = (String) request.getParameter("modifiedAdresse");
        String modifedCodePostal = (String) request.getParameter("modifiedCodePostal");
        String modifiedVille = (String) request.getParameter("modifiedVille");
        String modifiedEmail = (String) request.getParameter("modifiedEmail");

        if (modifiedNom != null) {
            System.out.println("dans modify 2");
            System.out.println("modifiedNom :" + modifiedNom
                    + "\n modifiedPrenom : " + modifiedPrenom
                    + "\n modifiedTeldom :" + modifiedTeldom
                    + "\n modifiedTelport : " + modifiedTelport
                    + "\n select : " + request.getSession().getAttribute("select")
            );
            Integer select = (Integer) request.getSession().getAttribute("select");
            connection.updateEmployee(select, modifiedNom, modifiedPrenom, modifiedTeldom, modifiedTelport, modifiedTelpro, modifiedAdresse, modifedCodePostal, modifiedVille, modifiedEmail);
            list = connection.getAllEmployees();
            session.setAttribute("listEmp", list);
            response.sendRedirect("admin.jsp");

        }

        //Suppression
        if (request.getParameter("delete") != null) {
            Integer select = Integer.parseInt(request.getParameter("select"));
            connection.deleteEmployee(select);
            list = connection.getAllEmployees();
            session.setAttribute("listEmp", list);
            response.sendRedirect("admin.jsp");
        }

        if (request.getParameter("logout") != null) {
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
