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
public class DatosNoCorrectosException extends Exception{

    /**
     * Creates a new instance of <code>DatosNoCorrectosException</code> without
     * detail message.
     */
    public DatosNoCorrectosException() {
    }

    /**
     * Constructs an instance of <code>DatosNoCorrectosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DatosNoCorrectosException(String msg) {
        super(msg);
    }
}
