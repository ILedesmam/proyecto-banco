package modeldao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.conexion;
import model.cliente;
import model.cuenta;
import model.ejecutivo;
import model.juridico;
import model.natural;

public class cuentadao {
	
	private static final String SQL_INGRESAR_CUENTA=
			"call banco.sp_ingresar_cuenta(?, ?, ?);";
	
	private static final String SQL_BUSCAR_CUENTA=
			"call banco.sp_buscar_cuenta(?);";
	
	private static final String SQL_LISTAR_CUENTAS=
			"SELECT * FROM banco.vw_listar_cuentas;";
	
	private static final String SQL_LISTAR_CUENATURALES=
			"SELECT * FROM banco.vw_listar_natural_cuentas;";
	
	private static final String SQL_LISTAR_CUEJURIDICOS=
			"SELECT * FROM banco.vw_listar_juridico_cuentas;";
	
	private static final String SQL_BLOQUEAR=
			"call banco.sp_bloquear_cuenta();";
	
	private static final String SQL_ELIMINAR=
			"call banco.sp_eliminar_cuenta();";
	
	private static final conexion cnn=conexion.saberEstado();
	
	public boolean ingresar(cuenta x) {
        CallableStatement ps;
        ResultSet rs;
        int bandera = 0;
        try {
            ps= cnn.getCnn().prepareCall(SQL_INGRESAR_CUENTA);
            ps.setString(1, x.getCliente().getPerRut());
            ps.setInt(2, x.getCueSaldo());
            ps.setInt(3, x.getCueSobregiro());
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
	public boolean buscar_cuentas(cuenta x) {
		CallableStatement ps;
		ResultSet rs;
		ArrayList<cuenta> cuentas = new ArrayList();
		try {
			ps= cnn.getCnn().prepareCall(SQL_BUSCAR_CUENTA);
			ps.setString(1, x.getCliente().getPerRut());
			rs = ps.executeQuery();
            while(rs.next()) {
            	ejecutivo e = new ejecutivo();
            	cliente c = new cliente();
            	e.setPerRut(rs.getString("EJECUTIVO"));
            	c.setPerRut(rs.getString("RUT"));
            	c.setPerNombre(rs.getString("NOMBRE"));
            	c.setPerApePaterno(rs.getString("PATERNO"));
            	c.setPerApeMaterno(rs.getString("MATERNO"));
            	c.setEje(e);
            	
            	cuentas.add(
            			new cuenta(rs.getInt("NUMERO_CUENTA"),
            					rs.getInt("SALDO"),
                            	null,
                            	rs.getString("ESTADO"),
                            	rs.getInt("SOBREGIRO"),
                            	c));
            }
		}catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
		return false;
	}
	
	public ArrayList<cuenta> listartodo() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<cuenta> cuentas= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR_CUENTAS);
            rs=ps.executeQuery();
            while(rs.next()) {
            	ejecutivo e = new ejecutivo();
            	cliente c = new cliente();
            	e.setPerRut(rs.getString("EJECUTIVO"));
            	c.setPerRut(rs.getString("RUT"));
            	c.setPerNombre(rs.getString("NOMBRE"));
            	c.setPerApePaterno(rs.getString("PATERNO"));
            	c.setPerApeMaterno(rs.getString("MATERNO"));
            	c.setPerNacionalidad(rs.getString("NACIONALIDAD"));
            	c.setPerFecNacimiento(rs.getString("NACIMIENTO"));
            	c.setCliCategoria(rs.getString("CATEGORIA"));
            	c.setEje(e);
            	cuentas.add(
            			new cuenta(rs.getInt("NUMERO_CUENTA"),
            					rs.getInt("SALDO"),
                            	null,
                            	rs.getString("ESTADO"),
                            	rs.getInt("SOBREGIRO"),
                            	c));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
        return cuentas;
    }
	
	public ArrayList<cuenta> listarnaturales() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<cuenta> cuentas= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR_CUENATURALES);
            rs=ps.executeQuery();
            while(rs.next()) {
            	ejecutivo e = new ejecutivo();
            	natural n = new natural();
            	e.setPerRut(rs.getString("EJECUTIVO"));
            	n.setPerRut(rs.getString("RUT"));
            	n.setPerNombre(rs.getString("NOMBRE"));
            	n.setPerApePaterno(rs.getString("PATERNO"));
            	n.setPerApeMaterno(rs.getString("MATERNO"));
            	n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
            	n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
            	n.setCliCategoria(rs.getString("CATEGORIA"));
            	n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
            	n.setEje(e);
            	cuentas.add(
            			new cuenta(rs.getInt("NUMERO_CUENTA"),
            					rs.getInt("SALDO"),
                            	rs.getString("FECHA_APERTURA"),
                            	rs.getString("ESTADO"),
                            	rs.getInt("SOBREGIRO"),
                            	n));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
        return cuentas;
    }
	
	public ArrayList<cuenta> listarjuridicos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<cuenta> cuentas= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR_CUEJURIDICOS);
            rs=ps.executeQuery();
            while(rs.next()) {
            	ejecutivo e = new ejecutivo();
            	juridico j = new juridico();
            	e.setPerRut(rs.getString("EJECUTIVO"));
            	j.setPerRut(rs.getString("RUT"));
            	j.setPerNombre(rs.getString("NOMBRE"));
            	j.setPerApePaterno(rs.getString("PATERNO"));
            	j.setPerApeMaterno(rs.getString("MATERNO"));
            	j.setPerNacionalidad(rs.getString("NACIONALIDAD"));
            	j.setPerFecNacimiento(rs.getString("NACIMIENTO"));
            	j.setCliCategoria(rs.getString("CATEGORIA"));
            	j.setJurRazSocial(rs.getString("RAZON_SOCIAL"));
            	j.setEje(e);
            	cuentas.add(
            			new cuenta(rs.getInt("NUMERO_CUENTA"),
            					rs.getInt("SALDO"),
                            	rs.getString("FECHA_APERTURA"),
                            	rs.getString("ESTADO"),
                            	rs.getInt("SOBREGIRO"),
                            	j));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
        return cuentas;
    }
	
	public boolean bloquear(cuenta x) {
		CallableStatement ps;
		ResultSet rs;
		int bandera = 0;
		try {
			ps= cnn.getCnn().prepareCall(SQL_BLOQUEAR);
			ps.setString(1, x.getCliente().getPerRut());
			rs = ps.executeQuery();
            while(rs.next()) {
            	bandera = rs.getInt("_resultado");
            	System.out.println(bandera);
            }
		}catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
		return false;
	}
	
	public boolean eliminar(cuenta x) {
		CallableStatement ps;
		ResultSet rs;
		int bandera = 0;
		try {
			ps= cnn.getCnn().prepareCall(SQL_ELIMINAR);
			ps.setString(1, x.getCliente().getPerRut());
			rs = ps.executeQuery();
            while(rs.next()) {
            	bandera = rs.getInt("_resultado");
            	System.out.println(bandera);
            }
		}catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally {
			cnn.cerrarConexion();
		}
		return false;
	}
	
	
}
