package hilos;

import tablero.Tablero;

import javax.swing.*;

import clases.Partida;

import java.awt.*;

public class HiloPelota extends Thread{
    JLabel pelota = null;
    JLabel Jugador1 = null;
    JLabel Jugador2 = null;
    JLabel marcador1 = null;
    JLabel marcador2 = null;
    int random;
    int direccion_Y;
    int direccion_X;
    int velocidad;
    Partida partida;

//JLabel marcador1, JLabel marcador2, JLabel Jugador1, JLabel Jugador2, JLabel pelota
    public HiloPelota(Partida partida,Tablero tablero, int velocidad){
    	this.marcador1 = tablero.jlMarcador1;
    	this.marcador2 = tablero.jlMarcador2;
    	this.partida = partida;
        this.pelota = tablero.jlPelota;
        this.Jugador1 = tablero.jlPaletaJugador1;
        this.Jugador2 = tablero.jlPaletaJugador2;
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
                    puntoJugador1();
				}else {
					if(pelota.getX() <= 0) {
					    reiniciarPelota();
					    puntoJugador2();
					}
				}

				/*Si toca la paleta de algun jugador rebota*/
                if (colision(Jugador1, pelota)) {
                    direccion_X = 1;
                }

                if (colision(Jugador2, pelota)) {
                   direccion_X = -1;
                }
                

                if(partida.Marcador_jugador1 == 5 ||partida.Marcador_jugador2 == 5){
                    JOptionPane.showMessageDialog(null,"Ha ganado el "+partida.ganador(),
                            "Fin de la partida", JOptionPane.INFORMATION_MESSAGE,null);
                    System.exit(0);
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
    
    private void puntoJugador2() {
        /*Se aumenta un punto el Jugador2*/
    	partida.Marcador_jugador2++;
        marcador2.setText(String.valueOf(partida.Marcador_jugador2));
    }

    private void puntoJugador1() {
         /*Se aumenta un punto el Jugador2*/
        partida.Marcador_jugador1++;
        marcador1.setText(String.valueOf(partida.Marcador_jugador1));
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