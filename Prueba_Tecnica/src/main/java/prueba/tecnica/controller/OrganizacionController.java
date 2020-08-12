package prueba.tecnica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import prueba.tecnica.model.Organizacion;
import prueba.tecnica.services.OrganizacionService;

@Controller
@RequestMapping("/organizacionController")
public class OrganizacionController {
	
	@Autowired
	private OrganizacionService service;

	@RequestMapping(value = "/getOrganizaciones", method = RequestMethod.POST)
	@ResponseBody
	public List<Organizacion> getOrganizaciones( HttpServletRequest request) {
		return service.getOrganizaciones();
	}
	
	@RequestMapping(value = "/addOrganizacion", method = RequestMethod.POST)
	@ResponseBody
	public String addOrganizacion(Organizacion organizacion, HttpServletRequest request) {

		try {
			System.out.println(organizacion);
			service.addOrganizacion(organizacion);
			return "SUCCESS";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
}
