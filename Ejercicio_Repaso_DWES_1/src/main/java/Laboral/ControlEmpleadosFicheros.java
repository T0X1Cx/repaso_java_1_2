/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author t0x1cx
 */
public class ControlEmpleadosFicheros extends Exception {

    private File fichero = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private List<Empleado> listaEmpleadosFichero = new ArrayList();
    //    public Empleado(int categoria, int anyos, String nombre, String DNI, Character sexo) throws DatosNoCorrectosException {
    private int categoria, anyos;
    private String nombre, DNI;
    private Character sexo;
    Nomina no = new Nomina();

    public List<Empleado> getEmpleadosFichero() {

        try {

            fichero = new File("/tmp/empleados.txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea = br.readLine();

            while (linea != null) {
                Empleado e;

                //System.out.println(linea);
                String[] prueba = linea.split(",");

                categoria = Integer.parseInt(prueba[0]);
                anyos = Integer.parseInt(prueba[1]);
                nombre = prueba[2];
                DNI = prueba[3];
                sexo = prueba[4].charAt(0);

                e = new Empleado(categoria, anyos, nombre, DNI, sexo);

                listaEmpleadosFichero.add(e);

                linea = br.readLine();

            }

        } catch (Exception e) {
            System.err.println("Error a la hora de abrir o leer el fichero\n");
        } finally {
            try {
                if (br == null) {
                    br.close();

                }

            } catch (Exception e) {
                System.err.println("Error a la hora de cerrar los recursos de lectura\n");
            }

        }
        return listaEmpleadosFichero;
    }

    public void escribeFichero(List<Empleado> emp) {

        FileWriter fich = null;
        PrintWriter pw = null;

        try {
            fich = new FileWriter("/tmp/salarios.dat");
            pw = new PrintWriter(fich);

            for (int i = 0; i < emp.size(); i++) {

                pw.println("DNI: " + emp.get(i).DNI + " Salario: " + no.sueldo(emp.get(i)));
                pw.println();
                pw.flush();

            }

        } catch (Exception e) {
            System.err.println("Error a la hora de crear o escribir en el fichero");
        } finally {
            if (fich == null) {
                try {
                    fich.close();
                } catch (Exception e) {
                    System.err.println("Error a la hora de cerrar el fichero");
                }

            }
        }

    }
    
    

}
