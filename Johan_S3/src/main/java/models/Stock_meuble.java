package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Stock_meuble {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "quantite")
	private Integer quantite;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;

	@J_Column(name = "id_client")
	private Integer id_client;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getQuantite() { return quantite; }
	public java.sql.Timestamp getDate_() { return date_; }
	public Integer getId_client() { return id_client; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_meuble(Integer id_meuble) throws Exception { this.id_meuble = id_meuble; }
	public void setQuantite(Integer quantite) throws Exception { this.quantite = quantite; }
	public void setDate_(java.sql.Timestamp date_) throws Exception { this.date_ = date_; }
	public void setId_client(Integer id_client) throws Exception { this.id_client = id_client; }
	public void setStatus(Integer status) throws Exception { this.status = status; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_meuble> objectDao = new Johan_DaoSQL<Stock_meuble>(Stock_meuble.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_meuble> objectDao = new Johan_DaoSQL<Stock_meuble>(Stock_meuble.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_meuble> objectDao = new Johan_DaoSQL<Stock_meuble>(Stock_meuble.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Stock_meuble GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_meuble> objectDao = new Johan_DaoSQL<Stock_meuble>(Stock_meuble.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Stock_meuble> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Stock_meuble> objectDao = new Johan_DaoSQL<Stock_meuble>(Stock_meuble.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
