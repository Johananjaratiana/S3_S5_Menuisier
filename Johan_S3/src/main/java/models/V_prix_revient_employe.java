  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_prix_revient_employe {
  	@J_Column(name = "id_reference")
	private Integer id_reference;

	@J_Column(name = "sum")
	private Float sum;


  	public Integer getId_reference() { return id_reference; }
	public Float getSum() { return sum; }

	public void setId_reference(Integer id_reference) { this.id_reference = id_reference; }
	public void setSum(Float sum) { this.sum = sum; }

      public List<V_prix_revient_employe> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_prix_revient_employe> objectDao = new Johan_DaoSQL<V_prix_revient_employe>(V_prix_revient_employe.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
