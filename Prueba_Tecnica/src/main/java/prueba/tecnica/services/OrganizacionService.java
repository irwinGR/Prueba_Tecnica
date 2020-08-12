package prueba.tecnica.services;

import java.util.List;

import prueba.tecnica.model.Organizacion;

public interface OrganizacionService {
	public List<Organizacion> getOrganizaciones();
	public void addOrganizacion(Organizacion o);
}
