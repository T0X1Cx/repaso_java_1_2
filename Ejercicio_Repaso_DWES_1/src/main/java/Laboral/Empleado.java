/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboral;

/**
 *
 * @author t0x1cx
 */
public class Empleado extends Persona {

    private int categoria;
    public int anyos;

    public Empleado(int categoria, int anyos, String nombre, String DNI, Character sexo) throws DatosNoCorrectosException {
        super(nombre, DNI, sexo);
        if (categoria < 0 || categoria > 10 || anyos < 0) {
            throw new DatosNoCorrectosException("Datos no correctos");

        } else {
            this.categoria = categoria;
            this.anyos = anyos;

        }

    }

    public Empleado(String nombre, String DNI, Character sexo) {
        super(nombre, DNI, sexo);
        this.categoria = 1;
        this.anyos = 0;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void incrAnyo() {
        anyos++;
    }

    public void imprime() {
        System.out.println("Categoria: " + categoria + " Años: " + anyos + " Nombre: " + nombre + " DNI " + DNI + " Sexo: " + sexo);
    }

    @Override
    public String toString() {
        return "Empleado: Categoria: " + categoria + " Años: " + anyos + " Nombre: " + nombre + " DNI: " + DNI + " Sexo: " + sexo;
    }
    
    

}
