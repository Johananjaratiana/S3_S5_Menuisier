package realmodels;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class Mode_fabrication {

    public static void InsertModeFabrication(models.Mode_fabrication mode_fabrication,Connection connection, HttpServletRequest request) throws Exception{
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
            mode_fabrication.save(false, connection);
        }catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
        }
    }
    
}
