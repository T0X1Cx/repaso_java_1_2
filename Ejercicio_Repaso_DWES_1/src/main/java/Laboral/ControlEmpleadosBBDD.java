/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

import java.sql.*;
import java.util.*;

/**
 *
 * @author t0x1cx
 */
public class ControlEmpleadosBBDD {

    private Connection con = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    private ConexionDB conexion = new ConexionDB();
    public int numFilas;

    public void getEmpleadosBBDD() throws DatosNoCorrectosException {
        Empleado emp;
        try {
            con = conexion.conexion();

            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM Empleados");

            while (rs.next()) {
                int id = rs.getInt(1);
                int categoria = rs.getInt(2);
                int anyos = rs.getInt(3);
                String nombre = rs.getString(4);
                String DNI = rs.getString(5);
                Character sexo = rs.getString(6).charAt(0);
                Double sueldo = rs.getDouble(7);

                System.out.println("ID: " + id + " Categoria: " + categoria + " Años: " + anyos + " Nombre: " + nombre + " DNI: " + DNI + " Sexo: " + sexo + " Sueldo: " + sueldo + " €");

            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta a la base de datos");
        }

    }

    public void altaEmpleado() throws DatosNoCorrectosException, SQLException {

        System.out.println("\nALTA NUEVO EMPLEADO\n");

        try {

            String seleccion = "";
            int id = 0;
            int categoria = 0;
            int anyos = 0;
            String nombre = "";
            String DNI = "";
            Character sexo = 'H';
            double sueldo = 0;
            do {
                System.out.println("Introduce el id o introduce 0 para aplicar el autoincrement");
                id = sc.nextInt();
                sc = new Scanner(System.in);
                System.out.println("Introduce la categoria (1 al 9)");
                sc = new Scanner(System.in);
                categoria = sc.nextInt();
                System.out.println("Introduce el numero de años");
                sc = new Scanner(System.in);
                anyos = sc.nextInt();
                System.out.println("Introduce el nombre (Sin apellidos)");
                sc = new Scanner(System.in);
                nombre = sc.nextLine();
                System.out.println("Introduce el DNI (Sin guiones incluyendo la letra)");
                DNI = sc.nextLine();
                System.out.println("Introduce el sexo (M para mujer y H para hombre, por defecto es H)");
                sc = new Scanner(System.in);
                sexo = sc.nextLine().charAt(0);
                System.out.println("¿Desea introducir otro empleado? (si o no)");
                seleccion = sc.nextLine();

                con = conexion.conexion();
                st = con.prepareStatement("SELECT sueldo");
                PreparedStatement st = con.prepareStatement("INSERT INTO Empleados (idEmpleado,categoria,anyos,nombre,DNI,sexo,sueldo) VALUES (?, ?, ?, ?, ?, ?, ?)");
                st.setInt(1, id);
                st.setInt(2, categoria);
                st.setInt(3, anyos);
                st.setString(4, nombre);
                st.setString(5, DNI);
                st.setString(6, String.valueOf(sexo));
                st.setDouble(7, sueldo);

                numFilas += st.executeUpdate();

                st = con.prepareStatement("UPDATE Empleados SET Empleados.sueldo = (SELECT sueldos_base.sueldo + 5000 * Empleados.anyos FROM sueldos_base, Empleados WHERE Empleados.categoria = sueldos_base.idSueldoBase AND Empleados.nombre = ?) WHERE Empleados.nombre = ?;");
                st.setString(1, nombre);
                st.setString(2, nombre);

                st.executeUpdate();

            } while (seleccion.equalsIgnoreCase("si"));

            System.out.println("Se han insertado un total de " + numFilas + " nuevos empleados");

        } catch (SQLException e) {
            System.err.println("Se ha producido un error a la hora de conectar o insertar el empleado en la base de datos");
        }

    }
    
    public void altaEmpleado(List<Empleado> emp) throws DatosNoCorrectosException, SQLException {
        
        
        
    }
    
    

}
