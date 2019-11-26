package Servlet;


import Entities.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@WebServlet(urlPatterns = {"/webapi"})
public class RESTClient extends HttpServlet {

    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target("http://localhost:8080/appv3/webapi/employee");
    Response requestResponse;

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

        HttpSession session = request.getSession();
        request.getRequestDispatcher("/restclient.jsp").include(request, response);
        if (request.getParameter("sendRequest") != null) {
            String id = request.getParameter("id");
            String selectedProtocol = request.getParameter("protocolChoice");
            switch (selectedProtocol) {
                case "GET":
                    if (id.isEmpty()) {
                        requestResponse = webTarget.request().get();
                        if (requestResponse.getStatus() != 500) {
                            session.setAttribute("response", webTarget.request().get(String.class));
                            break;
                        }
                        break;
                    }
                    String clientResponse = webTarget.path(id).request().get(String.class);
                    session.setAttribute("response", clientResponse);
                    break;

                case "POST":
                    ObjectMapper mapper = new ObjectMapper();
                    String inputJSON = request.getParameter("inputTextBoxArea");
                    Employee emp = mapper.readValue(inputJSON, Employee.class);
                    session.setAttribute("response", webTarget.request().accept(MediaType.TEXT_PLAIN).post(Entity.json(emp), String.class));
                    break;

                case "DELETE":
                    if(!id.isEmpty()){
                        clientResponse = webTarget.path(id).request().delete(String.class);
                        session.setAttribute("response", clientResponse);
                    }

            }


        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
