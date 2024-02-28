package realmodels;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;
import models.V_meuble;

public class Meuble extends models.Meuble {

    public Meuble(){}

    public static String GetFullName(models.V_meuble vm){
        return vm.getNom_produit() + " " + vm.getNom_style() + " " + vm.getNom_volume();
    }

    public static Float GetArea(models.V_stock_meuble_restante stock_meuble_restante){
        return stock_meuble_restante.getLongueur() * stock_meuble_restante.getLargeur() * stock_meuble_restante.getHauteur();
    }

    public static void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{
            Style.setDefaultDataToView(connection, request);
            Volume.setDefaultDataToView(connection, request);
            Produit.setDefaultDataToView(connection, request);
            Stock_meuble.setDefaultDataToView(connection, request);

            V_meuble vr = new V_meuble();
            List<V_meuble> meubles = vr.GetAll("", false, connection);
            request.setAttribute("meubles", meubles);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Meuble meuble = Johan_Servlet.constructByFormView(Meuble.class, request, isChildClass);
            meuble.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
}
