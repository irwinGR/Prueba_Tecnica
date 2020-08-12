package prueba.tecnica.dao;

import java.util.List;

import prueba.tecnica.model.Organizacion;

public interface OrganizacionDAO {
	public List<Organizacion> getOrganizaciones();
	public void addOrganizacion(Organizacion o);
}
