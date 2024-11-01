package model;

import java.util.Random;
import model.*;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;
    private JugadorHockey[] jugadores;
    private String[] players;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;
    private final int CANTIDAD_JUGADORES = 24;

    private int contadorEquipos = 0;
    private int contadorJugadores = 0;
    private int mainRef=0;
    private int assRef=0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
        jugadores = new JugadorHockey[CANTIDAD_JUGADORES];
        players = new String[CANTIDAD_JUGADORES];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        
        int equipo2 = random.nextInt(4);
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);
        if(equipo1==0){
            equipo1++;
        }
        if (equipo2==0){
            equipo2++;
        }

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);
        if(equipo1==0){
            equipo1++;
        }
        if (equipo2==0){
            equipo2++;
        }

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public String playGame(){
        String game="";
        Random rand = new Random();
        int x =rand.nextInt(4);
        if(x==0){
            x++;
        }

        
        String selectedTeam="";
        if(x==4){
            x--;
        }
        selectedTeam = equipos[x].getNombreEquipo();

        game += "Tiene posesion el "+selectedTeam;
        game += "\n";

        game += "Los jugadores estan en la cancha";
        game += "\n";

        /*switch (x) {
            case 1:
                for(int i=0;i<6;i++){
                    players[i]=jugadores[i].getNombreJugador();
                }
                break;
            case 2:
                for(int i=6;i<12;i++){
                    players[i]=jugadores[i].getNombreJugador();
             }
                break;
            case 3:
                for(int i=12;i<18;i++){
                    players[i]=jugadores[i].getNombreJugador();
                }
                break;
            case 4:
                for(int i=18;i<24;i++){
                    players[i]=jugadores[i].getNombreJugador();
                }
                break;
        }
        for(int i=0;i<6;i++){
            game += "- "+players[i];
        }*/

        Random select = new Random();
        int opt = select.nextInt(6);
        int opt2 = select.nextInt(6);
        int ref = select.nextInt(4);
        while (opt==opt2){
            opt2=select.nextInt(6);
        }
        game+="Jugador "+opt+jugadores[x].pasarla()+"a Jugador "+opt2;
        game+=arbitros[ref].desplazarse();
        return game;
    }


    public void registerPlayer(String nombre, int edad, Posicion posicion, String teamName){
        for(int i=0;i<equipos.length;i++){
            if(equipos[i].getNombreEquipo()==teamName){
                jugadores[contadorJugadores] = new JugadorHockey(nombre, edad, posicion);
                contadorJugadores++;
    
                equipos[i].agregarJugador(new JugadorHockey(nombre, edad, posicion));
            }
        }
    }
    public void registerReferee(String nombre, int edad){
        for(int i=0;i<arbitros.length;i++){
            if(arbitros[i]==null){
                if(mainRef!=2){
                    arbitros[i]=new ArbitroPrincipal(nombre, edad);
                    mainRef++;
                    System.out.println("Central referee registered");
                }
                if(assRef!=2){
                    arbitros[i]=new JuezDeLinea(nombre, edad);
                    assRef++;
                    System.out.println("Assistant referee registered");
                }
                
            }
        }
    }

    public void preloadPlayers(){
        registerPlayer("Jugador 1a", 23, Posicion.PORTERO, "Equipo 1");
        registerPlayer("Jugador 2a", 20, Posicion.DEFENSA, "Equipo 1");
        registerPlayer("Jugador 3a", 25, Posicion.DEFENSA, "Equipo 1");
        registerPlayer("Jugador 4a", 22, Posicion.ALA, "Equipo 1");
        registerPlayer("Jugador 5a", 21, Posicion.ALA, "Equipo 1");
        registerPlayer("Jugador 6a", 27, Posicion.CENTRO, "Equipo 1");

        registerPlayer("Jugador 1b", 28, Posicion.PORTERO, "Equipo 2");
        registerPlayer("Jugador 2b", 29, Posicion.DEFENSA, "Equipo 2");
        registerPlayer("Jugador 3b", 24, Posicion.DEFENSA, "Equipo 2");
        registerPlayer("Jugador 4b", 26, Posicion.ALA, "Equipo 2");
        registerPlayer("Jugador 5b", 29, Posicion.ALA, "Equipo 2");
        registerPlayer("Jugador 6b", 30, Posicion.CENTRO, "Equipo 2");

        registerPlayer("Jugador 1c", 19, Posicion.PORTERO, "Equipo 3");
        registerPlayer("Jugador 2c", 27, Posicion.DEFENSA, "Equipo 3");
        registerPlayer("Jugador 3c", 23, Posicion.DEFENSA, "Equipo 3");
        registerPlayer("Jugador 4c", 22, Posicion.ALA, "Equipo 3");
        registerPlayer("Jugador 5c", 21, Posicion.ALA, "Equipo 3");
        registerPlayer("Jugador 6c", 31, Posicion.CENTRO, "Equipo 3");

        registerPlayer("Jugador 1d", 30, Posicion.PORTERO, "Equipo 4");
        registerPlayer("Jugador 2d", 28, Posicion.DEFENSA, "Equipo 4");
        registerPlayer("Jugador 3d", 23, Posicion.DEFENSA, "Equipo 4");
        registerPlayer("Jugador 4d", 34, Posicion.ALA, "Equipo 4");
        registerPlayer("Jugador 5d", 31, Posicion.ALA, "Equipo 4");
        registerPlayer("Jugador 6d", 21, Posicion.CENTRO, "Equipo 4");


    }
    public void preloadTeams(){
        equipos[0]= new Equipo("Equipo 1");
        equipos[1]= new Equipo("Equipo 2");
        equipos[2]= new Equipo("Equipo 3");
        equipos[3]= new Equipo("Equipo 4");
    }
    public void preloadRefs(){
        registerReferee("Arbitro 1", 40);
        registerReferee("Arbitro 2", 35);
        registerReferee("Arbitro 3", 39);
        registerReferee("Arbitro 4", 42);
    } 

    /*
     * public void registerPlayer(String playerName, int playerNum, PlayerPosition playerPosition, String country, String teamName){
        Team teamToAdd = findTeam(teamName);
        if (teamToAdd!=null){
        
            players[playerCount]= new Player(playerName, playerNum, playerPosition, country, 0, 0, 0, 0, 0); 
            playerCount++;
            // 0's correspond to goals scored, assists, yellows, reds and matches played. 
            teamToAdd.addPlayer(new Player(playerName, playerNum, playerPosition, country,0,0,0,0,0));
            System.out.println("Player successfully added to "+teamToAdd.getTeamName());
        
        } else{
            System.out.println("Sorry, that team was not found.");
        }
    }
     */
}