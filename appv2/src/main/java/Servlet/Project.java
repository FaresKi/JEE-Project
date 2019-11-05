/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Employee;
import Entities.User;
import SessionBeans.EmployeeSB;
import SessionBeans.UserSB;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fareskissoum
 */
@WebServlet(urlPatterns = {"/Project"})
public class Project extends HttpServlet {
    @EJB
    EmployeeSB employeeSB;
    @EJB
    UserSB userSB;

    List<Employee> employees;

    HttpSession session;

    boolean selected = true;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("login");
        String password = request.getParameter("password");
        User loggedUser;
        employees = new ArrayList<>();
        employees = employeeSB.getAllEmployees();
        session = request.getSession();
        session.setAttribute("selected", selected);
        if (userName != null) {
            System.out.println("not null");
            loggedUser = userSB.getUser(userName, password);
            if (loggedUser.getAdmin()) {
                session.setAttribute("admin", loggedUser);
                session.setAttribute("listEmp", employees);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                session.setAttribute("user", loggedUser);
                session.setAttribute("listEmp", employees);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }

        if (request.getSession().getAttribute("admin") != null) {
            if (request.getParameter("add") != null) {
                request.getRequestDispatcher("add.jsp").include(request, response);
            }
            String addNom = request.getParameter("addNom");
            String addPrenom = request.getParameter("addPrenom");
            String addTeldom = request.getParameter("addTeldom");
            String addTelport = request.getParameter("addTelport");
            String addTelpro = request.getParameter("addTelpro");
            String addAdresse = request.getParameter("addAdresse");
            String addCodePostal = request.getParameter("addCodePostal");
            String addVille = request.getParameter("addVille");
            String addEmail = request.getParameter("addEmail");
            if (addNom != null) {
                if (request.getParameter("confirm") != null) {
                    employeeSB.addNewEmployee(addNom, addPrenom, addTeldom, addTelport, addTelpro, addAdresse, addCodePostal, addVille, addEmail);
                    employees = employeeSB.getAllEmployees();
                    session.setAttribute("listEmp", employees);
                    response.sendRedirect("admin.jsp");
                }
                if (request.getParameter("retour") != null) {
                    response.sendRedirect("admin.jsp");
                }

            }

            if (request.getParameter("modify") != null) {
                if (request.getParameter("select") != null) {
                    request.getRequestDispatcher("modify.jsp").include(request, response);
                    selected = true;
                    session.setAttribute("selected", selected);
                    int id = Integer.parseInt(request.getParameter("select"));
                    Employee changedEmp = employeeSB.getSpecificEmployee(id);
                    request.getSession().setAttribute("changedEmp", changedEmp);
                    request.getSession().setAttribute("select", id);
                    request.getRequestDispatcher("modify.jsp").forward(request, response);
                } else {
                    selected = false;
                    session.setAttribute("selected", selected);
                    request.getRequestDispatcher("admin.jsp").include(request, response);
                }

            }
            String modifiedNom = request.getParameter("modifiedNom");
            String modifiedPrenom = request.getParameter("modifiedPrenom");
            String modifiedTeldom = request.getParameter("modifiedTeldom");
            String modifiedTelport = request.getParameter("modifiedTelPortable");
            String modifiedTelpro = request.getParameter("modifiedTelPro");
            String modifiedAdresse = request.getParameter("modifiedAdresse");
            String modifedCodePostal = request.getParameter("modifiedCodePostal");
            String modifiedVille = request.getParameter("modifiedVille");
            String modifiedEmail = request.getParameter("modifiedEmail");

            if (modifiedNom != null) {
                if (request.getParameter("confirm") != null) {
                    int id = (int) request.getSession().getAttribute("select");
                    employeeSB.updateEmployee(modifiedNom, modifiedPrenom, modifiedTeldom, modifiedTelport, modifiedTelpro, modifiedAdresse, modifedCodePostal, modifiedVille, modifiedEmail, id);
                    employees = employeeSB.getAllEmployees();
                    session.setAttribute("listEmp", employees);
                    response.sendRedirect("admin.jsp");
                }

                if (request.getParameter("retour") != null) {
                    response.sendRedirect("admin.jsp");
                }
            }

            if (request.getParameter("delete") != null) {
                if (request.getParameter("select") != null) {
                    selected = true;
                    session.setAttribute("selected", selected);
                    int id = Integer.parseInt(request.getParameter("select"));
                    employeeSB.deleteEmployee(id);
                    employees = employeeSB.getAllEmployees();
                    session.setAttribute("listEmp", employees);
                    response.sendRedirect("admin.jsp");
                } else {
                    selected = false;
                    session.setAttribute("selected", selected);
                    response.sendRedirect("admin.jsp");
                }
            }

            if (request.getParameter("logout") != null) {
                session.removeAttribute("admin");
                response.sendRedirect("logout.html");
            }

        } else if (request.getSession().getAttribute("user") != null) {
            if (request.getParameter("logout") != null) {
                session.removeAttribute("user");
                response.sendRedirect("logout.html");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
