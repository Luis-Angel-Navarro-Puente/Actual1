package pe.edu.upc.pandemia.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JobHistoryId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer employee;
	private Date startDate;


	public JobHistoryId() {
		
	}



	public JobHistoryId(Integer employee, Date starDate) {
		super();
		this.employee = employee;
		this.startDate = starDate;
	}



	public Integer getEmployee() {
		return employee;
	}



	public void setEmployee(Integer employee) {
		this.employee = employee;
	}



	public Date getStarDate() {
		return startDate;
	}



	public void setStarDate(Date starDate) {
		this.startDate = starDate;
	}



	@Override
	public int hashCode() {
		return Objects.hash(employee, startDate);
	}

	

	@Override
	public boolean equals(Object obj) {
		//si es el mismo
		if(this==obj)
			return true;
		//si el objeto es nulo
		if(obj==null|| getClass() != obj.getClass())
			return false;
		//verificar que los atributos sean iguales
		JobHistoryId jobHistoryId = (JobHistoryId)obj;
		
		if(this.employee != jobHistoryId.employee)
			return false;
		if(this.startDate !=jobHistoryId.startDate)
			return false;
		return true;
					
		
	}
	
}