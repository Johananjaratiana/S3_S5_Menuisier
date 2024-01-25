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
                    models.Categorie cat = Johan_Servlet.constructByFormView(models.Categorie.class, request);
                    cat.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-categorie");
                    break;

                // ----------------------- STYLE
                case "crud-style":
                    Style.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;

                case "style-insert":
                    models.Style style = Johan_Servlet.constructByFormView(models.Style.class, request);
                    style.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-style");
                    break;

                // ----------------------- STYLE
                case "crud-unite":
                    Unite.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("unite.jsp").forward(request, response);
                    break;

                case "unite-insert":
                    models.Unite unite = Johan_Servlet.constructByFormView(models.Unite.class, request);
                    unite.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-unite");
                    break;

                // ----------------------- VOLUME
                case "crud-volume":
                    Volume.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("volume.jsp").forward(request, response);
                    break;

                case "volume-insert":
                    models.Volume volume = Johan_Servlet.constructByFormView(models.Volume.class, request);
                    volume.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-volume");
                    break;

                // ----------------------- MATERIEL
                case "crud-materiel":
                    Unite.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("materiel.jsp").forward(request, response);
                    break;

                case "materiel-insert":
                    models.Materiel materiel = Johan_Servlet.constructByFormView(models.Materiel.class, request);
                    materiel.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-materiel");
                    break;

                // ----------------------- STYLE MATERIEL
                case "crud-style-materiel":
                    Style.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    Style_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style-materiel.jsp").forward(request, response);
                    break;

                case "style-materiel-insert":
                    models.Style_materiel style_materiel = Johan_Servlet
                            .constructByFormView(models.Style_materiel.class, request);
                    Style.InsertStyleMateriel(connection, style_materiel, request);
                    Style.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    Style_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style-materiel.jsp").forward(request, response);
                    break;

                // ----------------------- PRODUIT
                case "crud-produit":
                    Categorie.setDefaultDataToView(connection, request);
                    Produit.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("produit.jsp").forward(request, response);
                    break;

                case "produit-insert":
                    models.Produit produit = Johan_Servlet.constructByFormView(models.Produit.class, request);
                    produit.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-produit");
                    break;

                // ----------------------- MEUBLE
                case "crud-meuble":
                    Style.setDefaultDataToView(connection, request);
                    Volume.setDefaultDataToView(connection, request);
                    Produit.setDefaultDataToView(connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("meuble.jsp").forward(request, response);
                    break;

                case "meuble-insert":
                    models.Meuble meuble = Johan_Servlet.constructByFormView(models.Meuble.class, request);
                    meuble.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-reference");
                    break;

                // ----------------------- STYLE REFERENCE
                case "crud-quantite-outils":
                    Meuble.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    Quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("quantite-outils.jsp").forward(request, response);
                    break;

                case "quantite-outils-insert":
                    models.Quantite_outils quantite_outils = Johan_Servlet
                            .constructByFormView(models.Quantite_outils.class, request);
                    Quantite_outils.InsertQuantiteUtiliser(quantite_outils, connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    Quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("quantite-outils.jsp").forward(request, response);
                    break;

                // ----------------------- STYLE FINAL
                case "formule-materiel-request":
                    Materiel.setDefaultDataToView(connection, request);
                    V_quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("formule-materiel.jsp").forward(request, response);
                    break;

                // ----------------------- FILTRE PRIX MATERIEL
                case "crud-prix-materiel":
                    Materiel.setDefaultDataToView(connection, request);
                    realmodels.Prix_materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-materiel.jsp").forward(request, response);
                    break;

                case "prix-materiel-insert":
                    models.Prix_materiel prix_materiel = Johan_Servlet.constructByFormView(models.Prix_materiel.class,
                            request);
                    prix_materiel.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-prix-materiel");
                    break;

                case "filtre-prix":
                    realmodels.V_filtre_produit_by_prix v_filtre_produit_by_prix = Johan_Servlet
                            .constructByFormView(realmodels.V_filtre_produit_by_prix.class, request);
                    v_filtre_produit_by_prix.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("filtre-prix.jsp").forward(request, response);
                    break;

                // ----------------------- STOCK
                case "crud-stock":
                    Materiel.setDefaultDataToView(connection, request);
                    V_full_stock_restante.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("entrer-stock.jsp").forward(request, response);
                    break;

                case "stock-insert":
                    models.Stock stock = Johan_Servlet.constructByFormView(models.Stock.class, request);
                    stock.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-stock");
                    break;

                // ----------------------- FABRICATION
                case "crud-fabrication":
                    Meuble.setDefaultDataToView(connection, request);
                    Fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("fabrication.jsp").forward(request, response);
                    break;

                case "fabrication-insert":
                    models.Fabrication fabrication = Johan_Servlet.constructByFormView(models.Fabrication.class, request);
                    realmodels.Fabrication.BuildReference(fabrication, connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    Fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("fabrication.jsp").forward(request, response);
                    break;

                // ----------------------- PRIX MEUBLE
                case "crud-prix-meuble":
                    Prix_meuble.setDefaultDataToView(connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("prix-meuble.jsp").forward(request, response);
                    break;

                case "prix-meuble-insert":
                    models.Prix_meuble prix_meuble = Johan_Servlet.constructByFormView(models.Prix_meuble.class,
                            request);
                    prix_meuble.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-prix-meuble");
                    break;

                // ----------------------- TYPE EMPLOYE
                case "crud-type-employee":
                    Type_employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("type-employee.jsp").forward(request, response);
                    break;

                case "type-employee-insert":
                    models.Type_employee type_employee = Johan_Servlet.constructByFormView(models.Type_employee.class,
                            request);
                    type_employee.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-type-employee");
                    break;

                // ----------------------- MODE DE FABRICATION
                case "crud-mode-fabrication":
                    Meuble.setDefaultDataToView(connection, request);
                    Type_employee.setDefaultDataToView(connection, request);
                    V_duree_fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("mode-fabrication.jsp").forward(request, response);
                    break;

                case "mode-fabrication-insert":
                    models.Mode_fabrication duree_fabrication = Johan_Servlet
                            .constructByFormView(models.Mode_fabrication.class, request);
                    Mode_fabrication.InsertModeFabrication(duree_fabrication, connection, request);
                    Meuble.setDefaultDataToView(connection, request);
                    Type_employee.setDefaultDataToView(connection, request);
                    V_duree_fabrication.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("mode-fabrication.jsp").forward(request, response);
                    break;

                // ----------------------- FILTRE BENEFICE
                case "benefice-meuble":
                    realmodels.V_benefice_meuble v_benefice_meuble = Johan_Servlet
                            .constructByFormView(realmodels.V_benefice_meuble.class, request);
                    v_benefice_meuble.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("intervalle-benefice.jsp").forward(request, response);
                    break;

                
                // ----------------------- EMPLOYEE
                case "crud-employee":
                    Employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employee.jsp").forward(request, response);
                    break;

                case "employee-insert":
                    Employee.save(request, connection);
                    Employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employee.jsp").forward(request, response);
                    break;

                // ----------------------- EMPLOYEMENT
                case "crud-employement":
                    Employement.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employement.jsp").forward(request, response);
                    break;

                case "employement-insert":
                    Employement.save(connection, request);
                    Employement.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("employement.jsp").forward(request, response);
                    break;
                
                // ----------------------- GRADE EMPLOYEE
                case "crud-grade-employee":
                    Grade_employee.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("grade-employee.jsp").forward(request, response);
                    break;

                case "grade-employee-insert":
                    models.Grade_employee grade_employee = Johan_Servlet.constructByFormView(models.Grade_employee.class, request);
                    grade_employee.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-grade-employee");
                    break;
                
                // ----------------------- GRADE PARAMS
                case "crud-grade-params":
                    Grade_params.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("grade-params.jsp").forward(request, response);
                    break;

                case "grade-params-insert":
                    Grade_params.save(request, connection);
                    request.getRequestDispatcher("grade-params.jsp").forward(request, response);
                    break;

                default:
                    throw new Exception("No action to be answered");

                
                // ----------------------- SEXE
                case "crud-sexe":
                    Sexe.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("sexe.jsp").forward(request, response);
                    break;

                case "sexe-insert":
                    models.Sexe sexe = Johan_Servlet.constructByFormView(models.Sexe.class, request);
                    sexe.save(false, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-sexe");
                    break;
                
                // ----------------------- CLIENT
                case "crud-client":
                    Client.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("client.jsp").forward(request, response);
                    break;

                case "client-insert":
                    Client.save(request, connection);
                    Client.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("client.jsp").forward(request, response);
                    break;

                
                // ----------------------- CLIENT
                case "crud-vente":
                    Vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("vente.jsp").forward(request, response);
                    break;

                case "vente-insert":
                    Vente.save(request, connection);
                    Vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("vente.jsp").forward(request, response);
                    break;
                
                // ---------------------- STATISTQUE
                case "statistique-vente":
                    Statistique_vente.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("statistique-vente.jsp").forward(request, response);
                    break;
                    

                    
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // response.sendError(0, ex.getMessage());
            // System.out.println("catch: "+action);
            // request.getRequestDispatcher(action+".jsp").forward(request, response);
        }
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
