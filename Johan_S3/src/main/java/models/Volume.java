package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Volume {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "longueur")
	private Float longueur;

	@J_Column(name = "largeur")
	private Float largeur;

	@J_Column(name = "hauteur")
	private Float hauteur;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "nom")
	private String nom;



  	public Integer getId() { return id; }
	public Float getLongueur() { return longueur; }
	public Float getLargeur() { return largeur; }
	public Float getHauteur() { return hauteur; }
	public Integer getStatus() { return status; }
	public String getNom() { return nom; }

	public void setId(Integer id) { this.id = id; }
	public void setLongueur(Float longueur) { this.longueur = longueur; }
	public void setLargeur(Float largeur) { this.largeur = largeur; }
	public void setHauteur(Float hauteur) { this.hauteur = hauteur; }
	public void setStatus(Integer status) { this.status = status; }
	public void setNom(String nom) { this.nom = nom; }

    public void save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Volume> objectDao = new Johan_DaoSQL<Volume>(Volume.class);
    		objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Volume> objectDao = new Johan_DaoSQL<Volume>(Volume.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Volume> objectDao = new Johan_DaoSQL<Volume>(Volume.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Volume GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Volume> objectDao = new Johan_DaoSQL<Volume>(Volume.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Volume> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Volume> objectDao = new Johan_DaoSQL<Volume>(Volume.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
