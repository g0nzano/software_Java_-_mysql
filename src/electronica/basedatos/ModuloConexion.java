package electronica.basedatos;
import java.sql.*;

/**
 *
 * @author Windows
 */
public class ModuloConexion {
    //metodo responsable de conexion con el base de datos
    public static Connection conector (){
        java.sql.Connection conexion = null;
        //linea abajo llama el driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenar informaciones referente al banco de datos
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password ="";
        //estableciendo la conexion con el banco de datos
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,user,password);
            return conexion;
        } catch (Exception e) {
            //linea de abajo como apoyo de esclarecer error de conexion
            //System.out.println(e);
            return null;
        }
    }
    
     
}
