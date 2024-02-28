package realmodels;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;

public class V_benefice_meuble extends models.V_benefice_meuble {

	@J_Column(name = "min")
    Double min;

	@J_Column(name = "max")
    Double max;

    
    public V_benefice_meuble(){}

    public String buildWhereRequest(){
        return " WHERE benefice >= " + this.getMin() + " AND benefice <= " + this.getMax(); 
    }
    public void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{

            if(this.getMin() == null || this.getMax() == null){
                request.setAttribute("filtre_prix_benefice_meubles", new ArrayList<realmodels.V_filtre_produit_by_prix>());
                return;
            }

            V_benefice_meuble vqo = new V_benefice_meuble();

            System.out.println(this.buildWhereRequest());

            List<models.V_benefice_meuble> filtre_prix_benefice_meubles = vqo.GetAll(this.buildWhereRequest(), false, connection);

            request.setAttribute("filtre_prix_benefice_meubles", filtre_prix_benefice_meubles);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public static String GetFullMeubleName(models.V_benefice_meuble benefice_meuble){
        return benefice_meuble.getNom_produit() + " " + benefice_meuble.getNom_style() + " " + benefice_meuble.getNom_volume();
    }
    
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
    
}
