package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    
    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    public void agregarJugador(JugadorHockey jugador) {
        for(int i=0;i<jugadores.length; i++){
            if (jugadores[i] == null){
                jugadores[i]= jugador;
                System.out.println("Player successfully added");
            }
        }    
    }
    public String getNombreEquipo(){
        return nombreEquipo;
    }


    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}
/*
 * public void addPlayer(Player player) {
        boolean added = false; // Flag to check if the player was added
        
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                System.out.println("Player successfully registered");
                added = true; // Set the flag to true
                break; // Exit the loop after adding the player
            }
        }
        // If the player was not added, it means the team is full
        if (!added) {
            System.out.println("Sorry. This team is already full");
        }
    }
 */