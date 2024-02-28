  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_nb_vente_par_style_par_mois_current_year {
  	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "nb_vente")
	private Integer nb_vente;

	@J_Column(name = "month")
	private java.math.BigDecimal month;


  	public Integer getId_style() { return id_style; }
	public Integer getNb_vente() { return nb_vente; }
	public java.math.BigDecimal getMonth() { return month; }

	public void setId_style(Integer id_style) { this.id_style = id_style; }
	public void setNb_vente(Integer nb_vente) { this.nb_vente = nb_vente; }
	public void setMonth(java.math.BigDecimal month) { this.month = month; }

      public List<V_nb_vente_par_style_par_mois_current_year> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_nb_vente_par_style_par_mois_current_year> objectDao = new Johan_DaoSQL<V_nb_vente_par_style_par_mois_current_year>(V_nb_vente_par_style_par_mois_current_year.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
