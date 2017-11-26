/**
 * 
 */
package modeldao;

import conexion.conexion;
import model.ejecutivo;
import model.juridico;
import model.natural;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;

/**
 * @author Ivan Ledesma
 *
 */
public class naturaldao {
	
	private static final String SQL_INGRESAR=
            "call banco.sp_ingresar_natural(?,?,?,?,?,?);";
	
	private static final String SQL_ACTUALIZAR=
			"call banco.sp_actualizar_natural(?,?,?,?,?,?,?,?,?);";
	
	
	
	private static final String SQL_LISTAR=
            "SELECT * FROM banco.vw_listar_cliente_naturales";
	
	
	private static final conexion cnn=conexion.saberEstado();
	
	public boolean ingresar(natural x) {
        CallableStatement ps;
        ResultSet rs;
        int bandera = 0;
        try {
            ps= cnn.getCnn().prepareCall(SQL_INGRESAR);
            ps.setString(1, x.getPerRut());
            ps.setString(2, x.getPerNombre());
            ps.setString(3, x.getPerApePaterno());
            ps.setString(4, x.getPerApeMaterno());
            ps.setString(5, x.getCliCategoria());
            ps.setInt(6, x.getNatPatrimonio());
            rs = ps.executeQuery();
            while(rs.next()) {
            	bandera = rs.getInt("_RESULTADO");
            	System.out.println(bandera);
            }
            if(bandera > 0) {
            	return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }
	
	public boolean actualizar(natural x) {
        CallableStatement ps;
        ResultSet rs;
        int bandera = 0;
        try {
            ps= cnn.getCnn().prepareCall(SQL_ACTUALIZAR);
            ps.setString(1, x.getPerRut());
            ps.setString(2, x.getPerNombre());
            ps.setString(3, x.getPerApePaterno());
            ps.setString(4, x.getPerApeMaterno());
            ps.setString(5, x.getPerNacionalidad());
            ps.setString(6, x.getPerFecNacimiento());
            ps.setString(7, x.getCliCategoria());
            ps.setString(8, x.getEje().getPerRut());
            ps.setInt(9, x.getNatPatrimonio());
            rs = ps.executeQuery();
            while(rs.next()) {
            	bandera = rs.getInt("_RESULTADO");
            	System.out.println(bandera);
            }
            if(bandera > 0) {
            	return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }
	
	
	
	public ArrayList<natural> listar() {
    
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<natural> naturales= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
            	ejecutivo e = new ejecutivo();
            	e.setPerRut(rs.getString("EJECUTIVO"));
                naturales.add(
                        new natural(rs.getString("RUT"),
                                rs.getString("NOMBRE"),
                                rs.getString("PATERNO"),
                                rs.getString("MATERNO"),
                                rs.getString("NACIONALIDAD"),
                                rs.getString("NACIMIENTO"),
                                rs.getString("CATEGORIA"),
                                e,
                                rs.getInt("PATRIMONIO")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
        return naturales;
    }

}
