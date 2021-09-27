/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jdk.nashorn.api.tree.TryTree;

/**
 *
 * @author t0x1cx
 */
public class ConexionDB {

    public Connection con = null;
    public static String url = "jdbc:mysql://127.0.0.1:3306/Ejercicio2_DWES";
    public static String username = "root";
    public static String password = "";

    public Connection conexion() throws SQLException {
        try {

            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.err.println("Se ha producido un error al conectar a la BBDD");

        } finally {
            try {
                if (con == null) {
                    con.close();

                }
            } catch (SQLException e) {
                System.err.println("Se ha producido un error al cerrar la conexion con la base de datos");
            }
        }
        return con;
    }

}
