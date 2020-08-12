package prueba.tecnica.dao.Impl;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import prueba.tecnica.dao.OrganizacionDAO;
import prueba.tecnica.model.Organizacion;
import prueba.tecnica.util.DAOUtil;

@Repository
public class OrganizacionDAOImpl extends JdbcDaoSupport implements OrganizacionDAO {

	@Autowired
	private DAOUtil daoUtil;
	
	@Autowired
	public OrganizacionDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	private static final String GET_ORGANIZACIONES = "SELECT * FROM organizacion";
	
	@Override
	public List<Organizacion> getOrganizaciones() {
		try {
			return this.getJdbcTemplate().query(GET_ORGANIZACIONES , new OrganizacionMapper());
		} catch (Exception ex) {
			System.out.println("Error al consultar Organizaciones: "+ ex);
			return null;
		}
		
	}
	
	private class OrganizacionMapper implements RowMapper<Organizacion> {

		@Override
		public Organizacion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Organizacion organizacion = new Organizacion();
			
			organizacion.setIdExterno(rs.getString("IDEXTERNO"));
			organizacion.setNombre(rs.getString("NOMBRE"));
			organizacion.setDireccion(rs.getString("DIRECCION"));
			try {
				organizacion.setCodigo(desencriptar(rs.getString("CODIGO")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			organizacion.setTelefono(rs.getString("TELEFONO"));
			return organizacion;

		}
	}
	

	private static final String ADD_ORGANIZACION = "INSERT INTO organizacion " 
			+ "(IDEXTERNO, "
			+ "NOMBRE, " 
			+ "DIRECCION, " 
			+ "CODIGO,TELEFONO) " 			
			+ "VALUES (?,?,?,?,?)";
	
	@Override
	public void addOrganizacion(Organizacion o) {
		try {
			this.getJdbcTemplate().update(ADD_ORGANIZACION,
					o.getIdExterno(),
					o.getNombre(),
					o.getDireccion(),
					encriptar(o.getCodigo()),
					o.getTelefono());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al insertar Organizaciones: "+ ex);

		}
	}
	
	 private static String encriptar(String s) throws UnsupportedEncodingException{
	        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    private static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }

}
