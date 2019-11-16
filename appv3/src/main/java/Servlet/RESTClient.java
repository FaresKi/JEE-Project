package Servlet;


import Entities.Employee;
import RestServices.service.EmployeeFacadeREST;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;

@WebServlet(urlPatterns = {"/webapi"})
public class RESTClient extends HttpServlet {

    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target("http://localhost:8080/appv3/webapi/employee");
    Response requestResponse;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getRequestDispatcher("/restclient.jsp").include(request, response);
        if (request.getParameter("sendRequest") == "Send") {
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
                    new EmployeeFacadeREST().create(emp);
                    break;

                case "DELETE":
                    if (!id.isEmpty()) {
                        clientResponse = webTarget.path(id).request().delete(String.class);
                        session.setAttribute("response", clientResponse);
                        break;
                    }
                    break;

                case "PUT":
                    if(!id.isEmpty()){
                        mapper = new ObjectMapper();
                        inputJSON = request.getParameter("inputTextBoxArea");
                        emp = mapper.readValue(inputJSON, Employee.class);
                        new EmployeeFacadeREST().edit(Integer.parseInt(id),emp);
                    }

            }


        }
        /*

         */


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
