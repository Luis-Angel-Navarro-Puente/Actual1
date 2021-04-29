package pe.edu.upc.pandemia.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.dao.IRegionDao;
import pe.edu.upc.pandemia.models.entities.Region2;
import pe.edu.upc.pandemia.service.IRegion2Service;

@Named
@RequestScoped

public class Region2ServiceImpl implements IRegion2Service{

	@Inject
	private IRegionDao rDao;
	
	@Override
	public void insert(Region2 reg) {
	
		rDao.insert(reg);	
	}

	@Override
	public List<Region2> list() {
	
		return rDao.list();
	}

	@Override
	public void delete(int idRegion) {
		rDao.delete(idRegion);
	}

}
