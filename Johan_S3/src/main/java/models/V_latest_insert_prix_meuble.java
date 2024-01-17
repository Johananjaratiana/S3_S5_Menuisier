  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_latest_insert_prix_meuble {
  	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "date_")
	private java.sql.Time date_;


  	public Integer getId_reference() { return id_reference; }
	public java.sql.Time getDate_() { return date_; }

	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setDate_(java.sql.Time date_) { this.date_ = date_; }

      public List<V_latest_insert_prix_meuble> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_latest_insert_prix_meuble> objectDao = new Johan_DaoSQL<V_latest_insert_prix_meuble>(V_latest_insert_prix_meuble.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
