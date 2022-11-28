/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregables4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joan_2k2
 */
public class DBUtil {

    private Connection conn;
    public String cadenaConexion = "jdbc:mysql://localhost:3306/libros";
    public String nombreUsuario = "2DAM";
    public String password = "2DAM2022";
    private static DBUtil db;

    public Connection getConexion() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(this.cadenaConexion, DBUtil.getDBUtil().nombreUsuario,DBUtil.getDBUtil().password);
            return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public synchronized static DBUtil getDBUtil(){
        if(db==null){
            db=new DBUtil();
        }
        return db;
    }

}