package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    
    public static final String URL = "jdbc:mysql://190.161.134.3:3306/banco";
    public static final String USERNAME = "alumno";
    public static final String PASSWORD = "alumno";
    public static conexion instance;
    private Connection cnn;
    

    private conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnn=DriverManager.getConnection(URL,USERNAME, PASSWORD);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static conexion saberEstado(){
        if(instance==null){
            instance=new conexion();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
    
}

