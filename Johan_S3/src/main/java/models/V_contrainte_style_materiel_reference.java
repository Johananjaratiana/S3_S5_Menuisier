  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_contrainte_style_materiel_reference {
  	@J_Column(name = "id")
	private Integer id;

	@J_Column(name = "id_style")
	private Integer id_style;

	@J_Column(name = "id_materiel")
	private Integer id_materiel;


  	public Integer getId() { return id; }
	public Integer getId_style() { return id_style; }
	public Integer getId_materiel() { return id_materiel; }

	public void setId(Integer id) { this.id = id; }
	public void setId_style(Integer id_style) { this.id_style = id_style; }
	public void setId_materiel(Integer id_materiel) { this.id_materiel = id_materiel; }

      public List<V_contrainte_style_materiel_reference> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_contrainte_style_materiel_reference> objectDao = new Johan_DaoSQL<V_contrainte_style_materiel_reference>(V_contrainte_style_materiel_reference.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
