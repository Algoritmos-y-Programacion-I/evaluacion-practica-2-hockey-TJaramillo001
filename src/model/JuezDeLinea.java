package model;

public class JuezDeLinea extends Arbitro implements IDesplazarseEnPistaSinPalo {
    public JuezDeLinea(String nombre, int edad) {
        super(nombre, edad);
    }
    public String desplazarse() {
        return nombre + " se desplaza en la pista como árbitro.";
    }
}