package clases;

import hilos.HiloJugador;
import hilos.HiloPelota;

import javax.swing.*;

public class Partida {
    JFrame FramePrincipal = null;
    JLabel Jugador1 = null;
    JLabel Jugador2 = null;
    JLabel Pelota = null;
    int velocidad;

    HiloJugador MovientoJugador1;
    HiloJugador MovientoJugador2;
    HiloPelota MovimeintoPelota;

    public Partida(JFrame FramePrincipal,JLabel Jugador1, JLabel Jugador2, JLabel Pelota, int velocidad){
        this.FramePrincipal = FramePrincipal;
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.Pelota = Pelota;
        this.velocidad = velocidad;

    }

    public void comenzarPartida() {
        MovientoJugador1 = new HiloJugador(FramePrincipal, Jugador1);
        MovientoJugador1.setName("Jugador1");
        MovientoJugador1.start();

        MovientoJugador2 = new HiloJugador(FramePrincipal, Jugador2);
        MovientoJugador2.setName("Jugador2");
        MovientoJugador2.start();

        MovimeintoPelota = new HiloPelota(FramePrincipal, Jugador1, Jugador2, Pelota, velocidad);
        MovimeintoPelota.setName("Pelota");
        MovimeintoPelota.start();
    }


}
