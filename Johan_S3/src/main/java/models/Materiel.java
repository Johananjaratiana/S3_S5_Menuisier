package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Materiel {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "id_unite")
	private Integer id_unite;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public Integer getId_unite() { return id_unite; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setId_unite(Integer id_unite) { this.id_unite = id_unite; }
	public void setStatus(Integer status) { this.status = status; }

    public void save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Materiel> objectDao = new Johan_DaoSQL<Materiel>(Materiel.class);
    		objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Materiel> objectDao = new Johan_DaoSQL<Materiel>(Materiel.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Materiel> objectDao = new Johan_DaoSQL<Materiel>(Materiel.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Materiel GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Materiel> objectDao = new Johan_DaoSQL<Materiel>(Materiel.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Materiel> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Materiel> objectDao = new Johan_DaoSQL<Materiel>(Materiel.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
