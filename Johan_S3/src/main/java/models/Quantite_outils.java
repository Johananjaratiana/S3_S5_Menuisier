package models;

import java.util.List;
import java.sql.*;
import johan.dao.annotation.*;
import johan.dao.Johan_DaoSQL;

public class Quantite_outils {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;

	@J_Column(name = "quantite")
	private Float quantite;

	@J_Column(name = "status")
	private Integer status;



  	public Integer getId() { return id; }
	public Integer getId_reference() { return id_reference; }
	public Integer getId_materiel() { return id_materiel; }
	public Float getQuantite() { return quantite; }
	public Integer getStatus() { return status; }

	public void setId(Integer id) { this.id = id; }
	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }
	public void setQuantite(Float quantite) { this.quantite = quantite; }
	public void setStatus(Integer status) { this.status = status; }

    public void save(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Quantite_outils> objectDao = new Johan_DaoSQL<Quantite_outils>(Quantite_outils.class);
    		objectDao.save(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void Update(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Quantite_outils> objectDao = new Johan_DaoSQL<Quantite_outils>(Quantite_outils.class);
    		objectDao.UpdateById(this, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public void DeleteById(Object id, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Quantite_outils> objectDao = new Johan_DaoSQL<Quantite_outils>(Quantite_outils.class);
    		objectDao.delete(id, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public Quantite_outils GetById(Object id, Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Quantite_outils> objectDao = new Johan_DaoSQL<Quantite_outils>(Quantite_outils.class);
    		return objectDao.SelectById(id, isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

  	public List<Quantite_outils> GetAll(Boolean isChildClass, Connection connection) throws Exception{
    	try{
    		Johan_DaoSQL<Quantite_outils> objectDao = new Johan_DaoSQL<Quantite_outils>(Quantite_outils.class);
    		return objectDao.SelectAll("", isChildClass, connection);
    	}catch(Exception ex){
    		throw new Exception(ex.getMessage());
    	}
  	}

}
