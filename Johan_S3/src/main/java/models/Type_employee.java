package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Type_employee {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "taux_horaire")
	private Float taux_horaire;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public Float getTaux_horaire() { return taux_horaire; }
	public java.sql.Timestamp getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setTaux_horaire(Float taux_horaire) { this.taux_horaire = taux_horaire; }
	public void setDate_(java.sql.Timestamp date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Type_employee> objectDao = new Johan_DaoSQL<Type_employee>(Type_employee.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Type_employee> objectDao = new Johan_DaoSQL<Type_employee>(Type_employee.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Type_employee> objectDao = new Johan_DaoSQL<Type_employee>(Type_employee.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Type_employee GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Type_employee> objectDao = new Johan_DaoSQL<Type_employee>(Type_employee.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Type_employee> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Type_employee> objectDao = new Johan_DaoSQL<Type_employee>(Type_employee.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
