package prueba.tecnica.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.dao.OrganizacionDAO;
import prueba.tecnica.model.Organizacion;
import prueba.tecnica.services.OrganizacionService;

@Service
public class OrganizacionServiceImplt implements OrganizacionService {

	@Autowired
	private OrganizacionDAO organizacionDAO;
	
	@Override
	public List<Organizacion> getOrganizaciones() {
		
		return organizacionDAO.getOrganizaciones();
	}

	@Override
	public void addOrganizacion(Organizacion o) {
		organizacionDAO.addOrganizacion(o);
	}
	
}
