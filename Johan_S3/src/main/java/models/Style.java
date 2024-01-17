package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Style {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setStatus(Integer status) { this.status = status; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style> objectDao = new Johan_DaoSQL<Style>(Style.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style> objectDao = new Johan_DaoSQL<Style>(Style.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style> objectDao = new Johan_DaoSQL<Style>(Style.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Style GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style> objectDao = new Johan_DaoSQL<Style>(Style.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Style> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Style> objectDao = new Johan_DaoSQL<Style>(Style.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
