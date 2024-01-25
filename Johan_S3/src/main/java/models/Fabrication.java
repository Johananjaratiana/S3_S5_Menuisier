package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Fabrication {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "quantite")
	private Integer quantite;

	@J_Column(name = "date_")
	private java.sql.Timestamp date_;



  	public Integer getId() { return id; }
	public Integer getId_meuble() { return id_meuble; }
	public Integer getQuantite() { return quantite; }
	public java.sql.Timestamp getDate_() { return date_; }

	public void setId(Integer id) { this.id = id; }
	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setQuantite(Integer quantite) { this.quantite = quantite; }
	public void setDate_(java.sql.Timestamp date_) { this.date_ = date_; }

    public Long save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Fabrication> objectDao = new Johan_DaoSQL<Fabrication>(Fabrication.class);
    		return objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Fabrication> objectDao = new Johan_DaoSQL<Fabrication>(Fabrication.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Fabrication> objectDao = new Johan_DaoSQL<Fabrication>(Fabrication.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Fabrication GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Fabrication> objectDao = new Johan_DaoSQL<Fabrication>(Fabrication.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Fabrication> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Fabrication> objectDao = new Johan_DaoSQL<Fabrication>(Fabrication.class);
    		return objectDao.SelectAll(addRequest, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
