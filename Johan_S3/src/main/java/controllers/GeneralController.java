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

@WebServlet(name = "GeneralController", urlPatterns = {"/Controller"})
public class GeneralController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Check if it has been connected */
        Personne connected = Login.getPeronneConnected(request);
        if(connected == null){
            response.sendRedirect("/Johan_S3");
            return;
        }else{
            request.setAttribute("utilisateur", connected);
        }
        /* Check if it has been connected */
        String action = request.getParameter("action");
        
        try (Connection connection = DatabaseConnection.GetConnection()){

            switch(action){
                    
                case "log-out" :
                    HttpSession log_out_session = request.getSession(false);
                    if (log_out_session != null)log_out_session.invalidate();
                    response.sendRedirect("/Johan_S3");
                    break;
                    
                case "deploiment" :
                    request.getRequestDispatcher("deploiment.jsp").forward(request, response);
                    break;
                
                case "clustering" :
                    request.getRequestDispatcher("clustering.jsp").forward(request, response);
                    break;
                    
                case "project" :
                    request.getRequestDispatcher("project.jsp").forward(request, response);
                    break;

                case "crud" :
                    request.getRequestDispatcher("crud.jsp").forward(request, response);
                    break;
                    
                case "list":
                    request.getRequestDispatcher("pagination.jsp").forward(request, response);
                    break;
                
                // ----------------------- CATEGORIE 
                case "crud-categorie":
                    Categorie.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("categorie.jsp").forward(request, response);
                    break;
                
                case "categorie-insert":
                    Categorie cat = Johan_Servlet.constructByFormView(Categorie.class, request);
                    cat.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-categorie");
                    break;

                // ----------------------- STYLE 
                case "crud-style":
                    Style.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;
                
                case "style-insert":
                    Style style = Johan_Servlet.constructByFormView(Style.class, request);
                    style.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-style");
                    break;

                // ----------------------- STYLE 
                case "crud-unite":
                    Unite.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("unite.jsp").forward(request, response);
                    break;
                
                case "unite-insert":
                    Unite unite = Johan_Servlet.constructByFormView(Unite.class, request);
                    unite.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-unite");
                    break;

                // ----------------------- VOLUME 
                case "crud-volume":
                    Volume.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("volume.jsp").forward(request, response);
                    break;
                
                case "volume-insert":
                    Volume volume = Johan_Servlet.constructByFormView(Volume.class, request);
                    volume.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-volume");
                    break;

                // ----------------------- MATERIEL 
                case "crud-materiel":
                    Unite.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("materiel.jsp").forward(request, response);
                    break;
                
                case "materiel-insert":
                    Materiel materiel = Johan_Servlet.constructByFormView(Materiel.class, request);
                    materiel.save(true, connection);
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
                    Style_materiel style_materiel = Johan_Servlet.constructByFormView(Style_materiel.class, request);
                    style_materiel.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-style-materiel");
                    break;
                
                // ----------------------- STYLE PRODUIT
                case "crud-produit":
                    Categorie.setDefaultDataToView(connection, request);
                    Produit.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("produit.jsp").forward(request, response);
                    break;
                
                case "produit-insert":
                    Produit produit = Johan_Servlet.constructByFormView(Produit.class, request);
                    produit.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-produit");
                    break;

                // ----------------------- STYLE REFERENCE 
                case "crud-reference":
                    Style.setDefaultDataToView(connection, request);
                    Volume.setDefaultDataToView(connection, request);
                    Produit.setDefaultDataToView(connection, request);
                    Reference.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("reference.jsp").forward(request, response);
                    break;
                
                case "reference-insert":
                    Reference reference = Johan_Servlet.constructByFormView(Reference.class, request);
                    reference.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-reference");
                    break;

                // ----------------------- STYLE REFERENCE 
                case "crud-quantite-outils":
                    Reference.setDefaultDataToView(connection, request);
                    Materiel.setDefaultDataToView(connection, request);
                    Quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("quantite-outils.jsp").forward(request, response);
                    break;
                
                case "quantite-outils-insert":
                    Quantite_outils quantite_outils = Johan_Servlet.constructByFormView(Quantite_outils.class, request);
                    quantite_outils.save(true, connection);
                    response.sendRedirect("/Johan_S3/Controller?action=crud-quantite-outils");
                    break;

                // ----------------------- STYLE FINAL 
                case "formule-materiel-request":
                    Materiel.setDefaultDataToView(connection, request);
                    V_quantite_outils.setDefaultDataToView(connection, request);
                    request.getRequestDispatcher("formule-materiel.jsp").forward(request, response);
                    break;
                    
                default:
                    throw new Exception("No action to be answered");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            //response.sendError(0, ex.getMessage());
            // System.out.println("catch: "+action);
            // request.getRequestDispatcher(action+".jsp").forward(request, response);
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
        processRequest(request, response);
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
