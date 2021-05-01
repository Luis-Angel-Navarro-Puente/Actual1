package pe.edu.upc.pandemia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.pandemia.dao.IRegionDao;
import pe.edu.upc.pandemia.models.entities.Region2;

public class Region2DaoImpl implements IRegionDao {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Region2 reg) {
		try {
			em.persist(reg);

		} catch (Exception e) {
			System.out.println(e.getMessage());// sysout
			System.out.println("Error al insertar region en el dao");

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region2> list() {
		List<Region2> lista=new ArrayList<Region2>();
		
		try {
Query q=em.createQuery("from Region2 r");
lista=(List<Region2>)q.getResultList();
			
		} catch (Exception e) {
System.out.println(e.getMessage());

		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idRegion) {
		Region2 re=new Region2();
		
		try {
re=em.getReference(Region2.class, idRegion);

em.remove(re);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
