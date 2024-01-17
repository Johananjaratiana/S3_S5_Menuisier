  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_prix_materiel_latest_date {
  	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "date_")
	private Object date_;


  	public Integer getId_materiel() { return id_materiel; }
	public Object getDate_() { return date_; }

	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setDate_(Object date_) { this.date_ = date_; }

      public List<V_prix_materiel_latest_date> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_prix_materiel_latest_date> objectDao = new Johan_DaoSQL<V_prix_materiel_latest_date>(V_prix_materiel_latest_date.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
