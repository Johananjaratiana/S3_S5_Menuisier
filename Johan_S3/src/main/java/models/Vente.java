package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Vente {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "id_client")
	private Integer id_client;

	@J_Column(name = "nb")
	private Integer nb;

	@J_Column(name = "date_")
	private java.sql.Date date_;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getId_client() { return id_client; }
	public Integer getNb() { return nb; }
	public java.sql.Date getDate_() { return date_; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setId_client(Integer id_client) { this.id_client = id_client; }
	public void setNb(Integer nb) { this.nb = nb; }
	public void setDate_(java.sql.Date date_) { this.date_ = date_; }
	public void setStatus(Integer status) { this.status = status; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Vente> objectDao = new Johan_DaoSQL<Vente>(Vente.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Vente> objectDao = new Johan_DaoSQL<Vente>(Vente.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Vente> objectDao = new Johan_DaoSQL<Vente>(Vente.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Vente GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Vente> objectDao = new Johan_DaoSQL<Vente>(Vente.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Vente> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Vente> objectDao = new Johan_DaoSQL<Vente>(Vente.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
