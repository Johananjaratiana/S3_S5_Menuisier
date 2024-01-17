package realmodels;

import java.sql.Connection;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import johan.dao.annotation.J_Column;

public class V_filtre_produit_by_prix extends models.V_filtre_produit_by_prix {

	@J_Column(name = "min")
    Double min;

	@J_Column(name = "max")
    Double max;

    
    public V_filtre_produit_by_prix(){}

    public String buildWhereRequest(){
        return " WHERE sum >= " + this.getMin() + " AND sum <= " + this.getMax(); 
    }
    public void setDefaultDataToView(Connection connection, HttpServletRequest request) throws Exception{
        try{

            if(this.getMin() == null){
                request.setAttribute("filtre_produit_by_prix", new ArrayList<realmodels.V_filtre_produit_by_prix>());
                return;
            }

            V_filtre_produit_by_prix vqo = new V_filtre_produit_by_prix();

            System.out.println(this.buildWhereRequest());

            List<models.V_filtre_produit_by_prix> filtre_produit_by_prix = vqo.GetAll(this.buildWhereRequest(), false, connection);

            request.setAttribute("filtre_produit_by_prix", filtre_produit_by_prix);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
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
