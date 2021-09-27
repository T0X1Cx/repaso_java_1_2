/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

import java.sql.*;

/**
 *
 * @author t0x1cx
 */
public class Nomina {

    private int SUELDO_BASE[] = new int[10];
    Connection con = null;
    ConexionDB conexion = new ConexionDB();
    Statement st = null;
    ResultSet rs = null;

    public void getSueldosBase() throws SQLException {

        con = conexion.conexion();

        st = con.createStatement();
        rs = st.executeQuery("SELECT sueldo FROM sueldos_base");

        int sueldo;
        int count = 0;
        while (rs.next()) {
            sueldo = rs.getInt(1);
            SUELDO_BASE[count] = sueldo;
            count++;

        }

    }

    public int sueldo(Empleado ep) throws SQLException {
        
        getSueldosBase();

        int sueldo = SUELDO_BASE[ep.getCategoria() - 1] + 5000 * ep.anyos;

        return sueldo;
    }

}
