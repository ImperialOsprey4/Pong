package hilos;

import javafx.scene.control.Tab;
import tablero.Tablero;

import javax.swing.*;
import java.awt.*;

public class HiloPelota extends Thread{
    Tablero tablero = null;
    JLabel pelota = null;
    JLabel Jugador1 = null;
    JLabel Jugador2 = null;
    JFrame frame = null;
    int random;
    int direccion_Y;
    int direccion_X;
    int velocidad;


    public HiloPelota(Tablero tablero,JFrame frame,JLabel Jugador1, JLabel Jugador2, JLabel pelota, int velocidad){
        pelota.setLocation(333,215);
        this.tablero = tablero;
        this.pelota = pelota;
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.frame = frame;
        this.velocidad = velocidad;
    }

	public void run() {
    	direccion();
        movimientoPelota();
    }

	public void movimientoPelota()
	{
		while(true) {
		    /*Validar que se mueva dentro del FRAME*/
			if(pelota.getY() <= 445 && pelota.getY() >= 0 && pelota.getX() >= 0 && pelota.getX() <= 658) {
				pelota.setLocation(pelota.getX()+direccion_X, pelota.getY()+direccion_Y);
				/*Si toca el lado inferior o superior rebota*/
				if(pelota.getY() >= 445) {
					direccion_Y = -1;
				}else {
					if(pelota.getY() <= 0) {
						direccion_Y = +1;
					}
				}

				/*Si toca el lado derecho o izquierdo se resetea su posicion inicial*/
				if(pelota.getX() >= 658) {
                    reiniciarPelota();
				}else {
					if(pelota.getX() <= 0) {
					    reiniciarPelota();
					}
				}

				/*Si toca la paleta de algun jugador rebota*/
                if (colision(Jugador1, pelota)) {
                    direccion_X = 1;
                }

                if (colision(Jugador2, pelota)) {
                   direccion_X = -1;
                }
			}
			/*Velocidad de la pelota*/
			try {
				sleep(velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


    public boolean colision(JLabel Jugador, JLabel Pelota){
        /*Si choca con un jugador devuelve TRUE*/
        Rectangle rectanguloJugador = Jugador.getBounds();
        Rectangle rectanguloPelota = Pelota.getBounds();

        if(rectanguloJugador.intersects(rectanguloPelota.getBounds())){
            return true;
        }else
            return false;
    }

    public boolean colisionDerecha(){
        /*Si choca con el lado derecho devuelve TRUE*/
        if(pelota.getX() >= 658) {
            return true;
        }else
            return false;
    }

    public boolean colisionizquierda(){
        /*Si choca con el lado izquierdo devuelve TRUE*/
        if(pelota.getX() <= 0) {
            return true;
        }else
            return false;
    }

    public void reiniciarPelota(){
        /*Reinicia la posicion de la pelota*/
        direccion();
        pelota.setLocation(333,215);
    }

    public void direccion(){
        /*Devuelve la direccion de salida de la pelota segun el RANDOM*/
        random = (int) (Math.random() * 4) + 1;
        switch (random){
            case 1:
               this.direccion_Y = 1;
               this.direccion_X = 1;
                break;
            case 2:
                this.direccion_Y = -1;
                this.direccion_X = -1;
                break;
            case 3:
                this.direccion_Y = 1;
                this.direccion_X = -1;
                break;
            case 4:
                this.direccion_Y = -1;
                this.direccion_X = 1;
                break;
        }
    }

}
