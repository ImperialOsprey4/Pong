package hilos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HiloJugador extends Thread
{
	JLabel paleta = null;
	JFrame FramePrincipal = null;

	public HiloJugador(JFrame FramePrincipal,JLabel paleta)
	{
		this.paleta=paleta;
		this.FramePrincipal=FramePrincipal;
		
	}

	public void run(){
	    if(currentThread().getName().equals("Jugador1")){
	        jugador1();
           }else
                jugador2();

        }

	public void jugador1()
	{
            FramePrincipal.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_W) {
                        if (paleta.getY() >= 10)
                            paleta.setLocation(25, paleta.getY() - 10);
                    }

                    if (key == KeyEvent.VK_S) {
                        if (paleta.getY() <= 360)
                            paleta.setLocation(25, paleta.getY() + 10);
                    }
                }
            });
			
	}

    private void jugador2() {
        FramePrincipal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP) {
                    if (paleta.getY() >= 10)
                        paleta.setLocation(650, paleta.getY() - 10);
                }

                if (key == KeyEvent.VK_DOWN) {
                    if (paleta.getY() <= 360)
                        paleta.setLocation(650, paleta.getY() + 10);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
