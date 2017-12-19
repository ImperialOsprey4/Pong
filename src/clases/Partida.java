package clases;

import hilos.HiloJugador;
import hilos.HiloPelota;
import tablero.Tablero;

import javax.swing.*;

public class Partida {
    Tablero tablero = null;
    int velocidad = 2;

    HiloJugador MovimientoJugador1;
    HiloJugador MovimientoJugador2;
   public  HiloPelota MovimientoPelota;

    int Marcador_jugador1 = 0;
    int Marcador_jugador2 = 0;

    public Partida(){
        inicio();
        comenzarPartida();
    }

    private void comenzarPartida() {

        /*Mientras la pelota este en movimiento se van contando los puntos hasta 5*/
        while (MovimientoPelota.isAlive()){
            if (MovimientoPelota.colisionizquierda()) {
                puntoJugador2();
            }

            if (MovimientoPelota.colisionDerecha()) {
                puntoJugador1();
            }

            if(Marcador_jugador1 == 5 ||Marcador_jugador2 == 5){
                MovimientoPelota.stop();
                JOptionPane.showMessageDialog(null,"Ha ganado el "+ganador(),
                        "Fin de la partida", JOptionPane.INFORMATION_MESSAGE,null);
                System.exit(0);
            }

        }

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

        MovimientoPelota = new HiloPelota(tablero,tablero.jFramePrincipal, tablero.jlPaletaJugador1,  tablero.jlPaletaJugador2, tablero.jlPelota, velocidad);
        MovimientoPelota.setName("Pelota");
        MovimientoPelota.start();
    }

    private void puntoJugador2() {
        /*Se aumenta un punto el Jugador2*/
        Marcador_jugador2++;
        tablero.jlMarcador2.setText(String.valueOf(Marcador_jugador2));
    }

    private void puntoJugador1() {
         /*Se aumenta un punto el Jugador2*/
        Marcador_jugador1++;
        tablero.jlMarcador1.setText(String.valueOf(Marcador_jugador1));
    }


    private String ganador(){
        /*Devuelve el ganador*/
        if(Marcador_jugador1 == 5)
            return "Jugador 1";
        else
            return "Jugador 2";
    }



}
