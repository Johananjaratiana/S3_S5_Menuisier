package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Employee {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "prenom")
	private String prenom;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "date_naissance")
	private java.sql.Date date_naissance;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public Integer getStatus() { return status; }
	public java.sql.Date getDate_naissance() { return date_naissance; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setNom(String nom) throws Exception { this.nom = nom; }
	public void setPrenom(String prenom) throws Exception { this.prenom = prenom; }
	public void setStatus(Integer status) throws Exception { this.status = status; }
	public void setDate_naissance(java.sql.Date date_naissance) throws Exception { this.date_naissance = date_naissance; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employee> objectDao = new Johan_DaoSQL<Employee>(Employee.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employee> objectDao = new Johan_DaoSQL<Employee>(Employee.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employee> objectDao = new Johan_DaoSQL<Employee>(Employee.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Employee GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employee> objectDao = new Johan_DaoSQL<Employee>(Employee.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Employee> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employee> objectDao = new Johan_DaoSQL<Employee>(Employee.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
