package model;

import model.*;

public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo, IPasar {
    protected String nombre;
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, Posicion posicion) {
        super(nombre, edad);
        this.posicion = posicion;
    }

    public String getNombreJugador(){
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }


    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    public String pasarla(){
        
        return " se la pasa a ";
    }
}