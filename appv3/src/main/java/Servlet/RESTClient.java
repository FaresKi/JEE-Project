package Servlet;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

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
import java.io.IOException;


@WebServlet(urlPatterns = {"/webapi"})
public class RESTClient extends HttpServlet {

    HttpSession session;
    String url = "http://localhost:8080/appv3-1.0/webapi/employee";

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

        request.getRequestDispatcher("/WEB-INF/restclient.jsp").include(request, response);
        session = request.getSession();
        if (request.getParameterMap().containsKey("action")) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            WebTarget webTarget = client.target(url);
            String output = "";
            ClientResponse responseCall = null;
            switch (request.getParameter("selectAPICall")) {
                case "Afficher tout les employes":
                    output = webTarget.request().get(String.class);
                    // Status 200 is successful.
                    //output = responseCall.getEntity(String)
                    session.setAttribute("response", output);

                    break;

                case "Ajouter un employe":
                    String input = request.getParameter("inputTextArea");
                    responseCall = webTarget.request("application/json").post(Entity.json(input), ClientResponse.class);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 204 && responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        session.setAttribute("response", "ça marche pas");
                    } else {
                        output = "Succès création, pas de ressources retournées";
                        session.setAttribute("response", output);

                    }
                    break;


                case "Afficher un employe":
                    webTarget = client.target(url + "/" + request.getParameter("employeIDEntered"));
                    output = webTarget.request("application/json").get(String.class);
                    session.setAttribute("response", output);
                    break;


                case "Supprimer un employe":
                    webTarget = client.target(url + "/" + request.getParameter("employeIDEntered"));
                    responseCall = webTarget.request("application/json").delete(ClientResponse.class);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 200 && responseCall.getStatus() != 204) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        session.setAttribute("response", output);

                    } else {
                        output = "Succès suppression, pas de ressources retournées";
                        session.setAttribute("response", output);

                    }
                    break;

                case "Modifier un employe":
                    String inputArea = request.getParameter("inputTextArea");
                    responseCall = webTarget.path(request.getParameter("employeIDEntered")).request("application/json").put(Entity.json(inputArea), ClientResponse.class);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 204 && responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        session.setAttribute("response", output);

                    } else {
                        output = "Succès modification, pas de ressources retournées";
                        session.setAttribute("response", output);

                    }
                    break;
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
