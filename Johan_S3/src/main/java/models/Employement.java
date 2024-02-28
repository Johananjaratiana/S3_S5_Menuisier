package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Employement {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_employee")
	private Integer id_employee;

	@J_Column(name = "id_type_employee")
	private Integer id_type_employee;

	@J_Column(name = "date_embauche")
	private java.sql.Date date_embauche;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_employee() { return id_employee; }
	public Integer getId_type_employee() { return id_type_employee; }
	public java.sql.Date getDate_embauche() { return date_embauche; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_employee(Integer id_employee) throws Exception { this.id_employee = id_employee; }
	public void setId_type_employee(Integer id_type_employee) throws Exception { this.id_type_employee = id_type_employee; }
	public void setDate_embauche(java.sql.Date date_embauche) throws Exception { this.date_embauche = date_embauche; }
	public void setStatus(Integer status) throws Exception { this.status = status; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employement> objectDao = new Johan_DaoSQL<Employement>(Employement.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employement> objectDao = new Johan_DaoSQL<Employement>(Employement.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employement> objectDao = new Johan_DaoSQL<Employement>(Employement.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Employement GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employement> objectDao = new Johan_DaoSQL<Employement>(Employement.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Employement> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Employement> objectDao = new Johan_DaoSQL<Employement>(Employement.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
