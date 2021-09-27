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
public class Persona {
    
    public String nombre;
    public String DNI;
    public Character sexo;

    public Persona(String nombre, String DNI, Character sexo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.sexo = sexo;
    }

    public Persona(String nombre, Character sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    public void imprime(){
        
        System.out.println("Nombre: " + nombre + " DNI: " + DNI);
    
}

   
    
        
}
