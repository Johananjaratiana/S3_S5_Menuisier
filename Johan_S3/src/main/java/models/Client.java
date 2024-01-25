package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Client {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "nom")
	private String nom;

	@J_Column(name = "prenom")
	private String prenom;

	@J_Column(name = "email")
	private String email;

	@J_Column(name = "id_sexe")
	private Integer id_sexe;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "date_naissance")
	private java.sql.Date date_naissance;



  	public Integer getId() { return id; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public String getEmail() { return email; }
	public Integer getId_sexe() { return id_sexe; }
	public Integer getStatus() { return status; }
	public java.sql.Date getDate_naissance() { return date_naissance; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setEmail(String email) { this.email = email; }
	public void setId_sexe(Integer id_sexe) { this.id_sexe = id_sexe; }
	public void setStatus(Integer status) { this.status = status; }
	public void setDate_naissance(java.sql.Date date_naissance) { this.date_naissance = date_naissance; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Client> objectDao = new Johan_DaoSQL<Client>(Client.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Client> objectDao = new Johan_DaoSQL<Client>(Client.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Client> objectDao = new Johan_DaoSQL<Client>(Client.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Client GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Client> objectDao = new Johan_DaoSQL<Client>(Client.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Client> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Client> objectDao = new Johan_DaoSQL<Client>(Client.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
