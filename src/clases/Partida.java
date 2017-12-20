package clases;

import hilos.HiloJugador;
import hilos.HiloPelota;
import tablero.Tablero;


public class Partida {
    Tablero tablero = null;
    int velocidad = 5;

    HiloJugador MovimientoJugador1;
    HiloJugador MovimientoJugador2;
    public  HiloPelota MovimientoPelota;

    public int Marcador_jugador1 = 0;
    public int Marcador_jugador2 = 0;

    public Partida(){
        inicio();
    }

    private void reiniciarMarcadores() {
        Marcador_jugador1 = 0;
        Marcador_jugador2 = 0;
        tablero.jlMarcador1.setText("0");
        tablero.jlMarcador2.setText("0");
    }

    public void inicio() {
        /*Se inician los hilos*/
        tablero = new Tablero();

        MovimientoJugador1 = new HiloJugador(tablero.jFramePrincipal, tablero.jlPaletaJugador1);
        MovimientoJugador1.setName("Jugador1");
        MovimientoJugador1.start();

        MovimientoJugador2 = new HiloJugador(tablero.jFramePrincipal, tablero.jlPaletaJugador2);
        MovimientoJugador2.setName("Jugador2");
        MovimientoJugador2.start();

        MovimientoPelota = new HiloPelota(this,tablero,velocidad);
        MovimientoPelota.setName("Pelota");
        MovimientoPelota.start();
    }


    public String ganador(){
        /*Devuelve el ganador*/
        if(Marcador_jugador1 == 5)
            return "Jugador 1";
        else
            return "Jugador 2";
    }
    



}