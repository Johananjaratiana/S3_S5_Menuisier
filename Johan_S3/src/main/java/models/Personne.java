package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Personne {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "prenom")
	private String prenom;

	@J_Column(name = "dtn")
	private java.sql.Date dtn;

	@J_Column(name = "email")
	private String email;

	@J_Column(name = "mdp")
	private String mdp;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public java.sql.Date getDtn() { return dtn; }
	public String getEmail() { return email; }
	public String getMdp() { return mdp; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setDtn(java.sql.Date dtn) { this.dtn = dtn; }
	public void setEmail(String email) { this.email = email; }
	public void setMdp(String mdp) { this.mdp = mdp; }

    public void save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Personne> objectDao = new Johan_DaoSQL<Personne>(Personne.class);
    		objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Personne> objectDao = new Johan_DaoSQL<Personne>(Personne.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Personne> objectDao = new Johan_DaoSQL<Personne>(Personne.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Personne GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Personne> objectDao = new Johan_DaoSQL<Personne>(Personne.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Personne> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Personne> objectDao = new Johan_DaoSQL<Personne>(Personne.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
