package realmodels;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import johan.servlet.Johan_Servlet;

public class Mode_fabrication extends models.Mode_fabrication{
    
    public static void ConstraintException(models.Mode_fabrication mode_fabrication) throws Exception{
        try{
            if(mode_fabrication.getNombre() == null){
                throw new Exception("Le nombre de personne qui doit travailler doit avoir une valeur.");
            }else if(mode_fabrication.getNombre().intValue() < 0){
                throw new Exception("Le nombre de personne ne peut pas être négatif.");
            }
            if(mode_fabrication.getDuree() == null){
                throw new Exception("Vous devez entrez une durée de travaille pour chaque employé");
            }else if(mode_fabrication.getDuree().intValue() < 0){
                throw new Exception("La durée de travail ne peut pas être négatif.");
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public static void Save(Connection connection, HttpServletRequest request) {
        try{
            Boolean isChildClass = true;
            Mode_fabrication mode_fabrication = Johan_Servlet.constructByFormView(Mode_fabrication.class, request, isChildClass);
            ConstraintException(mode_fabrication);
            mode_fabrication.save(isChildClass, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
