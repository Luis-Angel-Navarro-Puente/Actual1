/**
 * 
 */
package pe.edu.upc.pandemia.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")

public class Country {
	@Id
	@Column(name = "country_id", length = 2, nullable = false)
	private String id;

	@Column(name = "country_name", length = 40)
	private String name;
	
	@ManyToOne()
	@JoinColumn(name= "region_id", nullable= false)//foreign key
	private Region region;//region_ID
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Location> locations;
	
	//--constructor, getter y setter
	public Country() //constructor por defecto, constructor sin parametros
	{
		locations=new ArrayList<Location>(); //instanciar lista
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	

}
