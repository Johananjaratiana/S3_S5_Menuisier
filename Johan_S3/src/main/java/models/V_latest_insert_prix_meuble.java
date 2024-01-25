  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_latest_insert_prix_meuble {
  	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "date_")
	private java.sql.Time date_;


  	public Integer getId_meuble() { return id_meuble; }
	public java.sql.Time getDate_() { return date_; }

	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
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
