package Servlets;

import JavaBeans.AdminUser;
import JavaBeans.User;
import Utilities.ConnectionClass;
import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     *
     *
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);

    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            ConnectionClass connection = new ConnectionClass();
            
            if (connection.getUser(userName, password).getClass() == AdminUser.class) {
                AdminUser admin = new AdminUser(userName, password);
                session.setAttribute("admin", admin);
                response.sendRedirect(request.getContextPath() + "/home");
            } else if (connection.getUser(userName, password).getClass() == User.class) {
                User user = new User(userName, password);
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
