package Servlet;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/webapi"})
public class RESTClient extends HttpServlet {

    HttpSession session;
    String url = "http://localhost:8080/appv3/webapi/employee";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/restclient.jsp").include(request, response);
        session = request.getSession();
        if (request.getParameterMap().containsKey("action")) {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            String output = "";
            ClientResponse responseCall = null;
            switch (request.getParameter("selectAPICall")) {
                case "Afficher tout les employes":
                    responseCall = webResource.accept("application/json").get(ClientResponse.class);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        session.setAttribute("response", output);
                    } else {
                        output = responseCall.getEntity(String.class);
                        session.setAttribute("response", output);
                    }
                    break;
                case "Ajouter un employe":
                    String input = request.getParameter("inputTextArea");
                    responseCall = webResource.type("application/json").post(ClientResponse.class, input);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 204 && responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        output += responseCall.getEntity(String.class);
                        session.setAttribute("response", output);

                    } else {
                        output = "Succès création, pas de ressources retournées";
                        session.setAttribute("response", output);

                    }
                    break;


                case "Afficher un employe":
                    responseCall = webResource.path(request.getParameter("employeIDEntered")).accept("application/json").get(ClientResponse.class);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        session.setAttribute("response", output);

                    } else {
                        output = responseCall.getEntity(String.class);
                        session.setAttribute("response", output);

                    }
                    break;


                case "Supprimer un employe":
                    responseCall = webResource.path(request.getParameter("employeIDEntered")).accept("application/json").delete(ClientResponse.class);
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
                    responseCall = webResource.path(request.getParameter("employeIDEntered")).type("application/json").put(ClientResponse.class, inputArea);
                    // Status 200 is successful.
                    if (responseCall.getStatus() != 204 && responseCall.getStatus() != 200) {
                        output = "Failed with HTTP Error code: " + responseCall.getStatus();
                        output += responseCall.getEntity(String.class);
                        session.setAttribute("response", output);

                    } else {
                        output = "Succès modification, pas de ressources retournées";
                        session.setAttribute("response", output);

                    }
                    break;


            }


        }
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
