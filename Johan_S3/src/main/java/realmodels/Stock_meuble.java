package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_check_left_by_quantite_outils;

public class Stock_meuble extends models.Stock_meuble{

    public static String BuildWhereRequest(models.Stock_meuble fabrication){
        return " WHERE id_meuble = " + fabrication.getId_meuble();
    }

    public static String GetManquanteOrNoMateriel(models.Stock_meuble fabrication, List<V_check_left_by_quantite_outils> list_restante){
        String answer = "";
        for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
            if(v_check_left_by_quantite_outils.getQuantite().doubleValue() * fabrication.getQuantite().doubleValue() > v_check_left_by_quantite_outils.getReste().doubleValue()){
                answer += " Il manque " + 
                            ( v_check_left_by_quantite_outils.getQuantite().doubleValue() * fabrication.getQuantite().doubleValue() - v_check_left_by_quantite_outils.getReste().doubleValue() ) + 
                        " de " + v_check_left_by_quantite_outils.getNom_materiel() + ". ";
            }
        }
        if(list_restante.size() == 0)answer = "Ce meuble n` est pas encore bien conçus.";
        return answer;
    }

    public static void GetInStock_materiel(models.Stock_meuble fabrication, List<V_check_left_by_quantite_outils> list_restante, Connection connection) throws Exception{
        try{
            models.Stock_materiel stock_materiel ;
            for (V_check_left_by_quantite_outils v_check_left_by_quantite_outils : list_restante) {
                stock_materiel = new models.Stock_materiel();
                stock_materiel.setId_fabrication(fabrication.getId());
                stock_materiel.setId_materiel(v_check_left_by_quantite_outils.getId_materiel());
                stock_materiel.setNombre((-1) * v_check_left_by_quantite_outils.getQuantite() * fabrication.getQuantite());
                stock_materiel.save(false, connection);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Stock_meuble fabrication = Johan_Servlet.constructByFormView(Stock_meuble.class, request, isChildClass);

            V_check_left_by_quantite_outils vclbqo = new V_check_left_by_quantite_outils();
            List<V_check_left_by_quantite_outils> list_restante = vclbqo.GetAll(BuildWhereRequest(fabrication), false, connection);
            String exception = GetManquanteOrNoMateriel(fabrication, list_restante);

            if(fabrication.getQuantite().intValue() < 0 )throw new Exception("Negatif");
            if(exception.length() != 0) throw new Exception(exception);
            fabrication.setQuantite(fabrication.getQuantite());   
            Long id_fabrication = fabrication.save(isChildClass, connection);
            fabrication.setId(Integer.parseInt(id_fabrication.toString()));
            GetInStock_materiel(fabrication, list_restante, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            models.V_stock_meuble_restante vr = new models.V_stock_meuble_restante();
            List<models.V_stock_meuble_restante> fabrications = vr.GetAll("", false, connection);
            request.setAttribute("fabrications", fabrications);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static Float GetAreaUsedByStock(models.V_stock_meuble_restante stock_meuble_restante){
        return realmodels.Meuble.GetArea(stock_meuble_restante) * stock_meuble_restante.getQuantite();
    }
    
}
