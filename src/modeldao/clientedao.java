package modeldao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.conexion;
import model.cliente;
import model.ejecutivo;
import model.natural;

public class clientedao {
	
	private static final String SQL_BUSCAR_CLIENTE =
			"call banco.sp_buscar_cliente(?);";
	private static final String SQL_LISTAR=
			"SELECT * FROM banco.vw_listar_clientes;";
	
	
	
	private static final conexion cnn=conexion.saberEstado();
	
	
		public boolean buscarforcuenta(cliente x) {
			CallableStatement ps;
			ResultSet rs;
			int bandera = 0;
			try {
				ps= cnn.getCnn().prepareCall(SQL_BUSCAR_CLIENTE);
				ps.setString(1, x.getPerRut());
				rs = ps.executeQuery();
	            while(rs.next()) {
	            	ejecutivo e = new ejecutivo();
	            	e.setPerRut(rs.getString("EJECUTIVO"));
	            	x.setPerNombre(rs.getString("NOMBRE"));
	            	x.setPerApePaterno(rs.getString("PATERNO"));
	            	x.setPerApeMaterno(rs.getString("MATERNO"));
	            	x.setPerFecNacimiento(rs.getString("NACIMIENTO"));
	            	x.setCliCategoria(rs.getString("CATEGORIA"));
	            	x.setEje(e);
	            	
	            	
	            }
			}catch (SQLException ex) {
	            System.out.println(ex.toString());
	        }finally {
				cnn.cerrarConexion();
			}
			return false;
		}

		public ArrayList<cliente> listar() {
	        PreparedStatement ps;
	        ResultSet rs;
	        ArrayList<cliente> clientes= new ArrayList();
	        try {
	            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
	            rs=ps.executeQuery();
	            while(rs.next()){
	            	ejecutivo e = new ejecutivo();
	            	e.setPerRut(rs.getString("EJECUTIVO"));
	            	clientes.add(
	            			new cliente(rs.getString("RUT"),
                                rs.getString("NOMBRE"),
                                rs.getString("PATERNO"),
                                rs.getString("MATERNO"),
                                rs.getString("NACIONALIDAD"),
                                rs.getString("NACIMIENTO"),
                                rs.getString("CATEGORIA"),
                                e));
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.toString());
	        }finally {
				cnn.cerrarConexion();
			}
	        return clientes;
	    }
}	
