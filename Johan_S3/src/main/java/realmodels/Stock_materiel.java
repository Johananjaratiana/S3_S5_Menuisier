package realmodels;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Stock_materiel extends models.Stock_materiel {

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Stock_materiel stock_materiel = Johan_Servlet.constructByFormView(Stock_materiel.class, request, isChildClass);
            stock_materiel.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
