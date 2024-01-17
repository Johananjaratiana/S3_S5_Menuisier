package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Prix_materiel {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "prix_unitaire")
	private Float prix_unitaire;

	@J_Column(name = "date_")
	private Object date_;



  	public Integer getId() { return id; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getPrix_unitaire() { return prix_unitaire; }
	public Object getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setPrix_unitaire(Float prix_unitaire) { this.prix_unitaire = prix_unitaire; }
	public void setDate_(Object date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_materiel> objectDao = new Johan_DaoSQL<Prix_materiel>(Prix_materiel.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_materiel> objectDao = new Johan_DaoSQL<Prix_materiel>(Prix_materiel.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_materiel> objectDao = new Johan_DaoSQL<Prix_materiel>(Prix_materiel.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Prix_materiel GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_materiel> objectDao = new Johan_DaoSQL<Prix_materiel>(Prix_materiel.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Prix_materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Prix_materiel> objectDao = new Johan_DaoSQL<Prix_materiel>(Prix_materiel.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
