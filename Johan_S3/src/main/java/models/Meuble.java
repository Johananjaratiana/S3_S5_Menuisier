package models;

import java.lang.Exception;
import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Meuble {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "id_volume")
	private Integer id_volume;

	@J_Column(name = "status")
	private Integer status;

	@J_Column(name = "id_produit")
	private Integer id_produit;



  	public Integer getId() { return id; }
	public Integer getId_style() { return id_style; }
	public Integer getId_volume() { return id_volume; }
	public Integer getStatus() { return status; }
	public Integer getId_produit() { return id_produit; }

	public void setId(Integer id) throws Exception { this.id = id; }
	public void setId_style(Integer id_style) throws Exception { this.id_style = id_style; }
	public void setId_volume(Integer id_volume) throws Exception { this.id_volume = id_volume; }
	public void setStatus(Integer status) throws Exception { this.status = status; }
	public void setId_produit(Integer id_produit) throws Exception { this.id_produit = id_produit; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Meuble> objectDao = new Johan_DaoSQL<Meuble>(Meuble.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Meuble> objectDao = new Johan_DaoSQL<Meuble>(Meuble.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Meuble> objectDao = new Johan_DaoSQL<Meuble>(Meuble.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Meuble GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Meuble> objectDao = new Johan_DaoSQL<Meuble>(Meuble.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Meuble> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Meuble> objectDao = new Johan_DaoSQL<Meuble>(Meuble.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
