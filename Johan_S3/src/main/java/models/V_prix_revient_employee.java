  package models;

  import java.util.List;
  import java.sql.*;
  import johan.dao.annotation.*;
  import johan.dao.Johan_DaoSQL;

  public class V_prix_revient_employee {
  	@J_Column(name = "id_meuble")
	private Integer id_meuble;

	@J_Column(name = "sum")
	private Float sum;


  	public Integer getId_meuble() { return id_meuble; }
	public Float getSum() { return sum; }

	public void setId_meuble(Integer id_meuble) { this.id_meuble = id_meuble; }
	public void setSum(Float sum) { this.sum = sum; }

      public List<V_prix_revient_employee> GetAll(String addRequest, Boolean isChildClass, Connection connection) throws Exception{
      	try{
      		Johan_DaoSQL<V_prix_revient_employee> objectDao = new Johan_DaoSQL<V_prix_revient_employee>(V_prix_revient_employee.class);
      		return objectDao.SelectAll(addRequest, isChildClass, connection);
      	}catch(Exception ex){
      		throw new Exception(ex.getMessage());
      	}
    }

  }
