package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import johan.servlet.*;
import realmodels.*;
import java.sql.*;
import services.DatabaseConnection;

@WebServlet(name = "GeneralController", urlPatterns = { "/Controller" })
public class GeneralController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Check if it has been connected */
        Personne connected = Login.getPeronneConnected(request);
        if (connected == null) {
            response.sendRedirect("/Johan_S3");
            return;
        } else {
            request.setAttribute("utilisateur", connected);
        }
        /* Check if it has been connected */
        String action = request.getParameter("action");

        try (Connection connection = DatabaseConnection.GetConnection()) {

            switch (action) {

                case "log-out":
                    HttpSession log_out_session = request.getSession(false);
                    if (log_out_session != null)
                        log_out_session.invalidate();
                    response.sendRedirect("/Johan_S3");
                    break;

                case "deploiment":
                    request.getRequestDispatcher("deploiment.jsp").forward(request, response);
                    break;

                case "clustering":
                    request.getRequestDispatcher("clustering.jsp").forward(request, response);
                    break;

                case "project":
                    request.getRequestDispatcher("project.jsp").forward(request, response);
                    break;

                case "crud":
                    request.getRequestDispatcher("crud.jsp").forward(request, response);
                    break;

                // ----------------------- CATEGORIE
                case "crud-categorie":
                    Categorie.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("categorie.jsp").forward(request, response);
                    break;

                case "categorie-insert":
                    Categorie.Save(connection, request);
                    Categorie.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("categorie.jsp").forward(request, response);
                    break;

                // ----------------------- STYLE
                case "crud-style":
                    Style.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;

                case "style-insert":
                    Style.Save(connection, request);
                    Style.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;

                // ----------------------- STYLE
                case "crud-unite":
                    Unite.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("unite.jsp").forward(request, response);
                    break;

                case "unite-insert":
                    Unite.Save(connection, request);
                    Unite.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("unite.jsp").forward(request, response);
                    break;

                // ----------------------- VOLUME
                case "crud-volume":
                    Volume.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("volume.jsp").forward(request, response);
                    break;

                case "volume-insert":
                    Volume.Save(connection, request);
                    Volume.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("volume.jsp").forward(request, response);
                    break;

                // ----------------------- MATERIEL
                case "crud-materiel":
                    Materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("materiel.jsp").forward(request, response);
                    break;

                case "materiel-insert":
                    Materiel.Save(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("materiel.jsp").forward(request, response);
                    break;

                // ----------------------- STYLE MATERIEL
                case "crud-style-materiel":
                    Style_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style-materiel.jsp").forward(request, response);
                    break;

                case "style-materiel-insert":
                    Style_materiel.Save(connection, request);
                    Style_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style-materiel.jsp").forward(request, response);
                    break;

                // ----------------------- PRODUIT
                case "crud-produit":
                    Produit.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("produit.jsp").forward(request, response);
                    break;

                case "produit-insert":
                    Produit.Save(connection, request);
                    Produit.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("produit.jsp").forward(request, response);
                    break;

                // ----------------------- MEUBLE
                case "crud-meuble":
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("meuble.jsp").forward(request, response);
                    break;

                case "meuble-insert":
                    Meuble.Save(connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("meuble.jsp").forward(request, response);
                    break;

                // ----------------------- STYLE REFERENCE
                case "crud-quantite-outils":
                    Quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("quantite-outils.jsp").forward(request, response);
                    break;

                case "quantite-outils-insert":
                    Quantite_outils.Save(connection, request);
                    Quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("quantite-outils.jsp").forward(request, response);
                    break;

                // ----------------------- MODE FABRICATION
                case "formule-materiel-request":
                    Materiel.setDefaultDataToView(connection, request);
                    V_quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("formule-materiel.jsp").forward(request, response);
                    break;

                // ----------------------- FILTRE PRIX MATERIEL
                case "crud-prix-materiel":
                    Prix_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-materiel.jsp").forward(request, response);
                    break;

                case "prix-materiel-insert":
                    Prix_materiel.Save(connection, request);
                    Prix_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-materiel.jsp").forward(request, response);
                    break;

                case "filtre-prix":
                    V_filtre_produit_by_prix v_filtre_produit_by_prix = Johan_Servlet
                            .constructByFormView(realmodels.V_filtre_produit_by_prix.class, request, false);
                    v_filtre_produit_by_prix.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("filtre-prix.jsp").forward(request, response);
                    break;

                // ----------------------- STOCK MATERIEL
                case "crud-stock-materiel":
                    V_stock_materiel_restante.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("stock-materiel.jsp").forward(request, response);
                    break;

                case "stock-materiel-insert":
                    Stock_materiel.Save(connection, request);
                    V_stock_materiel_restante.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("stock-materiel.jsp").forward(request, response);
                    break;

                // ----------------------- FABRICATION OU STOCK MEUBLE
                case "crud-fabrication":
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("fabrication.jsp").forward(request, response);
                    break;

                case "fabrication-insert":
                    Stock_meuble.Save(connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("fabrication.jsp").forward(request, response);
                    break;

                // ----------------------- PRIX MEUBLE
                case "crud-prix-meuble":
                    Prix_meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-meuble.jsp").forward(request, response);
                    break;

                case "prix-meuble-insert":
                    Prix_meuble.Save(connection, request);
                    Prix_meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-meuble.jsp").forward(request, response);
                    break;

                // ----------------------- TYPE EMPLOYE
                case "crud-type-employee":
                    Type_employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("type-employee.jsp").forward(request, response);
                    break;

                case "type-employee-insert":
                    Type_employee.Save(connection, request);
                    Type_employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("type-employee.jsp").forward(request, response);
                    break;

                // ----------------------- MODE DE FABRICATION
                case "crud-mode-fabrication":
                    V_duree_fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("mode-fabrication.jsp").forward(request, response);
                    break;

                case "mode-fabrication-insert":
                    Mode_fabrication.Save(connection, request);
                    V_duree_fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("mode-fabrication.jsp").forward(request, response);
                    break;

                // ----------------------- FILTRE BENEFICE
                case "benefice-meuble":
                    V_benefice_meuble v_benefice_meuble = Johan_Servlet
                            .constructByFormView(V_benefice_meuble.class, request, false);
                    v_benefice_meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("intervalle-benefice.jsp").forward(request, response);
                    break;

                
                // ----------------------- EMPLOYEE
                case "crud-employee":
                    Employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employee.jsp").forward(request, response);
                    break;

                case "employee-insert":
                    Employee.Save(request, connection);
                    Employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employee.jsp").forward(request, response);
                    break;

                // ----------------------- EMPLOYEMENT
                case "crud-employement":
                    Employement.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employement.jsp").forward(request, response);
                    break;

                case "employement-insert":
                    Employement.Save(connection, request);
                    Employement.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employement.jsp").forward(request, response);
                    break;
                
                // ----------------------- GRADE EMPLOYEE
                case "crud-grade-employee":
                    Grade_employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("grade-employee.jsp").forward(request, response);
                    break;

                case "grade-employee-insert":
                    Grade_employee.Save(connection, request);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-grade-employee");
                    break;
                
                // ----------------------- GRADE PARAMS
                case "crud-grade-params":
                    Grade_params.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("grade-params.jsp").forward(request, response);
                    break;

                case "grade-params-insert":
                    Grade_params.Save(request, connection);
                    request.getRequestDispatcher("grade-params.jsp").forward(request, response);
                    break;
                
                // ----------------------- SEXE
                case "crud-sexe":
                    Sexe.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("sexe.jsp").forward(request, response);
                    break;

                case "sexe-insert":
                    Sexe.Save(connection, request);
                    Sexe.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("sexe.jsp").forward(request, response);
                    break;
                
                // ----------------------- CLIENT
                case "crud-client":
                    Client.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("client.jsp").forward(request, response);
                    break;

                case "client-insert":
                    Client.Save(request, connection);
                    Client.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("client.jsp").forward(request, response);
                    break;

                
                // ----------------------- CLIENT
                case "crud-vente":
                    Vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("vente.jsp").forward(request, response);
                    break;

                case "vente-insert":
                    Vente.Save(request, connection);
                    Vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("vente.jsp").forward(request, response);
                    break;
                
                // ---------------------- STATISTQUE VENTE
                case "statistique-vente":
                    Statistique_vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("statistique-vente.jsp").forward(request, response);
                    break;

                // ---------------------- STATISTQUE GLOBAL
                case "statistique-global":
                    Statistique_global.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("statistique-global.jsp").forward(request, response);
                    break;


                
                default:
                    throw new Exception("No action to be answered");
                    
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // response.sendError(0, ex.getMessage());
            // System.out.println("catch: "+action);
            // request.getRequestDispatcher(action+".jsp").forward(request, response);
        }
    }

    private void Save(Connection connection, HttpServletRequest request) {
        // TODO
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
