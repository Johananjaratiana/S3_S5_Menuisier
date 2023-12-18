package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

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
        
        try{
            
            System.out.println(action);
            String[] parts = action.split("_insert");
            System.out.println("length="+parts.length);
            if(parts.length==1){
                Class concerned = Class.forName("models."+Util.capitalize(action));
                System.out.println("classe name: "+concerned.getSimpleName());
                Method createjsp = concerned.getMethod("getContent", (Class[]) null);
                createjsp.invoke(null, (Object[]) null);
                request.getRequestDispatcher(action+".jsp").forward(request, response);
            }
            
            /*switch(action){
                    
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
                    
                case "list":
                    request.getRequestDispatcher("pagination.jsp").forward(request, response);
                    break;
                    
                case "categorie":
                    request.getRequestDispatcher("categorie.jsp").forward(request, response);
                    break;
                    
                case "style_insert":
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;
                    
                case "style_insert2":
                    Style style = new Style(request);
                    Table.insert(style);
                    request.getRequestDispatcher("style.jsp").forward(request, response);
                    break;
                    
                case "categorie_insert":
                    Categorie cat = new Categorie(request);
                    Table.insert(cat);
                    request.getRequestDispatcher("categorie.jsp").forward(request, response);
                    break;                    

                case "materiel":
                    List<Unite> unit = Unite.selectAll();
                    request.setAttribute("unites", unit);
                    request.getRequestDispatcher("outils.jsp").forward(request, response);
                    break; 
                    
                case "style_materiel":
                    Vector<Table> styles = Table.fetch("Style", null);
                    Vector<Table> materiels = Table.fetch("Materiel", null);
                    System.out.println(styles.size());
                    request.setAttribute("styles", styles);
                    request.setAttribute("materiels", materiels);
                    request.getRequestDispatcher("styleMateriels.jsp").forward(request, response);
                    break; 
                
                case "mat_insert":
                    Materiel catt = new Materiel(request);
                    catt.insert();
                    request.getRequestDispatcher("project.jsp").forward(request, response);
                    break;
                case "stymat_insert":
                    StyleMateriel stmat = new StyleMateriel(request);
                    Table.insert(stmat);
                    request.getRequestDispatcher("project.jsp").forward(request, response);
                    break;
                    
                default:
                    throw new Exception("No action to be answered");
            }*/
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            //response.sendError(0, ex.getMessage());
            System.out.println("catch: "+action);
            request.getRequestDispatcher(action+".jsp").forward(request, response);
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
