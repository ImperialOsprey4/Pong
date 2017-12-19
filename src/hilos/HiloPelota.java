package hilos;

import javax.swing.*;

public class HiloPelota extends Thread{
    JLabel pelota = null;
    JFrame frame = null;
    public int direccion_Y = 1;
    public int direccion_X = 1;
    int velocidad;

    public HiloPelota(JFrame frame, JLabel pelota, int velocidad){
        this.pelota = pelota;
        this.frame = frame;
        this.velocidad = velocidad;
    }

	public void run() {
    	movimientoPelota();
    }

	private void movimientoPelota()
	{
		while(true) {
			if(pelota.getY() <= 445 && pelota.getY() >= 0 && pelota.getX() >= 0 && pelota.getX() <= 658) {
				pelota.setLocation(pelota.getX()+direccion_X, pelota.getY()+direccion_Y);
				if(pelota.getY() >= 445) {
					direccion_Y = -1;
				}else {
					if(pelota.getY() <= 0) {
						direccion_Y = +1;
					}
				}
				
				if(pelota.getX() >= 658) {
					direccion_X = -1;
				}else {
					if(pelota.getX() <= 0) {
                        direccion_X = +1;
					}
				}
				
				
			}
					
			try {
				sleep(velocidad);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void reiniciarPelota(){

    }
    
	
}
