package prueba.tecnica.model;

public class Organizacion {

	private String idExterno;
	private String nombre;
	private String direccion;
	private String codigo;
	private String telefono;
	
	public Organizacion() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Organizacion(String idExterno, String nombre, String direccion, String codigo) {
		super();
		this.idExterno = idExterno;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
		this.telefono = telefono;
	}



	public String getIdExterno() {
		return idExterno;
	}

	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
