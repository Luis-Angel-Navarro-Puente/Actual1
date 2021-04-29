package pe.edu.upc.pandemia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.models.entities.Region2;
import pe.edu.upc.pandemia.service.IRegion2Service;

@Named
@RequestScoped
public class RegionController {
	@Inject
	private IRegion2Service rservice;
	
	//variables
	
	private Region2 region;
	
	List<Region2> listaRegiones;

	//constructores
	@PostConstruct
	public void init()
	{
		this.region =new Region2();
		this.listaRegiones=new ArrayList<Region2>();
		this.list();
	}
	
	//metodos especializados
	public String newRegion()
	{
		this.setRegion(new Region2());
		return "region.xhtml";
	}
	
	public void insert()
	{
		try {
			rservice.insert(region);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controler de region");
		}
	}
	
	public void list()
	{
		try {
			
			listaRegiones=rservice.list();
			
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de region");
		}
	}
	
	public void delet(Region2 re)
	{
	try {
		rservice.delete(re.getId());
		this.list();
	} catch (Exception e) {
		System.out.println("Error al eliminar en el controller de la region");
	}	
	}
	
	//getter setter
	public IRegion2Service getRservice() {
		return rservice;
	}

	public void setRservice(IRegion2Service rservice) {
		this.rservice = rservice;
	}

	public Region2 getRegion() {
		return region;
	}

	public void setRegion(Region2 region) {
		this.region = region;
	}
	
	

}
