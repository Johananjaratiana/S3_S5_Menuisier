package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Commande {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "quantite")
	private Integer quantite;

	@J_Column(name = "date_")
	private Object date_;



  	public Integer getId() { return id; }
	public Integer getId_reference() { return id_reference; }
	public Integer getQuantite() { return quantite; }
	public Object getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setQuantite(Integer quantite) { this.quantite = quantite; }
	public void setDate_(Object date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Commande> objectDao = new Johan_DaoSQL<Commande>(Commande.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Commande> objectDao = new Johan_DaoSQL<Commande>(Commande.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Commande> objectDao = new Johan_DaoSQL<Commande>(Commande.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Commande GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Commande> objectDao = new Johan_DaoSQL<Commande>(Commande.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Commande> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Commande> objectDao = new Johan_DaoSQL<Commande>(Commande.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
