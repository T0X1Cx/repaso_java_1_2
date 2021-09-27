/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

import java.sql.SQLException;
import java.util.*;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author t0x1cx
 */
public class Main {

//    Crear la clase CalculaNominas con un programa principal que:
//4.1. Cree el empleado: “James Cosling”, dni=32000032G, sexo=’M’, categoría=4,
//años=7
//4.2. Cree el empleado: “Ada Lovelace”, dni=32000031R, sexo=’F’
//4.3. Declare un método privado escribe que reciba los valores de los dos
//empleados e imprima sus atributos y el sueldo que cada uno gana.
//4.4. Haga una llamada en el programa principal a ese método.
//4.5. Incremente los años trabajados del segundo empleado y haga que la categoría
//del primero sea 9.
//4.6. Imprima de nuevo ambos empleados y su sueldo.
    public static void main(String[] args) throws SQLException, DatosNoCorrectosException {
        System.out.println("\n");

        System.out.println("\n\n");

        ControlEmpleadosFicheros empleadosFichero = new ControlEmpleadosFicheros();

        empleadosFichero.escribeFichero(empleadosFichero.getEmpleadosFichero());

        ControlEmpleadosBBDD empleadosBBDD = new ControlEmpleadosBBDD();

        empleadosBBDD.getEmpleadosBBDD();

        empleadosBBDD.altaEmpleado();

        empleadosBBDD.getEmpleadosBBDD();

    }

}
