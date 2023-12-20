/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import realmodels.Personne;

/**
 *
 * @author johan
 */
@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        /* Default action if connected */
        Personne connected = Login.getPeronneConnected(request);
        if(connected != null){
            response.sendRedirect("/Johan_S3/Controller?action=project");
            return;
        }
        /* Default action if connected */
        
        /* Page to create account */
        if(request.getParameter("create-account") != null){
            request.getRequestDispatcher("create-account.jsp").forward(request, response);
            return;             
        }
        /* Page to create account */
        
        /* Create account */
        if(request.getParameter("action") != null && request.getParameter("action").equals("create-account")){
            Personne pers = Personne.AjouterUtilisateur(request);
            HttpSession session = request.getSession();
            session.setAttribute("utilisateurConnecte", pers);
            response.sendRedirect("/Johan_S3");
            return;
        }
        /* Create account */
        
        /* Login*/
        request.getRequestDispatcher("login.jsp").forward(request, response);
        /* Login*/
        }catch(Exception ex){
            ex.printStackTrace();
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
