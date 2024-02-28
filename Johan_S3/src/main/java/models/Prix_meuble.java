package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Prix_meuble {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "prix_vente")
	private Float prix_vente;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Float getPrix_vente() { return prix_vente; }
	public java.sql.Timestamp getDate_() { return date_; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_meuble(Integer id_meuble) throws Exception { this.id_meuble = id_meuble; }
	public void setPrix_vente(Float prix_vente) throws Exception { this.prix_vente = prix_vente; }
	public void setDate_(java.sql.Timestamp date_) throws Exception { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_meuble> objectDao = new Johan_DaoSQL<Prix_meuble>(Prix_meuble.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_meuble> objectDao = new Johan_DaoSQL<Prix_meuble>(Prix_meuble.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_meuble> objectDao = new Johan_DaoSQL<Prix_meuble>(Prix_meuble.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Prix_meuble GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_meuble> objectDao = new Johan_DaoSQL<Prix_meuble>(Prix_meuble.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Prix_meuble> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_meuble> objectDao = new Johan_DaoSQL<Prix_meuble>(Prix_meuble.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
