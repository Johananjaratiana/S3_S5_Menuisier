package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Prix_reference {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "prix_vente")
	private Float prix_vente;

	@J_Column(name = "date_")
	private java.sql.Time date_;



  	public Integer getId() { return id; }
	public Integer getId_reference() { return id_reference; }
	public Float getPrix_vente() { return prix_vente; }
	public java.sql.Time getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setPrix_vente(Float prix_vente) { this.prix_vente = prix_vente; }
	public void setDate_(java.sql.Time date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_reference> objectDao = new Johan_DaoSQL<Prix_reference>(Prix_reference.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_reference> objectDao = new Johan_DaoSQL<Prix_reference>(Prix_reference.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_reference> objectDao = new Johan_DaoSQL<Prix_reference>(Prix_reference.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Prix_reference GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_reference> objectDao = new Johan_DaoSQL<Prix_reference>(Prix_reference.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Prix_reference> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_reference> objectDao = new Johan_DaoSQL<Prix_reference>(Prix_reference.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
