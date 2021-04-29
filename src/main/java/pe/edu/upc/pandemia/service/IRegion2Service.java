package pe.edu.upc.pandemia.service;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Region2;

public interface IRegion2Service {

	public void insert(Region2 reg);

	public List<Region2> list();

	public void delete(int idRegion);
}
