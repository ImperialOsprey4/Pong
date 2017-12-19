package tablero;

import clases.Partida;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Tablero {
    JFrame jFramePrincipal = null;
    JPanel jPanelPrincipal = null;
    JLabel jlPaletaJugador1 = null;
    JLabel jlPaletaJugador2 = null;
    JLabel jlMarcador1 = null;
    JLabel jlMarcador2 = null;
    JLabel jlPelota = null;
    JLabel jlLinea = null;

    Partida PartidaPong;


    public Tablero() {
        inicio();
        jFramePrincipal.setVisible(true);
        jFramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        jFramePrincipal = new JFrame("Ping - Pong");
        jFramePrincipal.setResizable(false);
        jFramePrincipal.setLayout(null);
        jFramePrincipal.setSize(700, 500);
        jFramePrincipal.setLocationRelativeTo(null);

        jPanelPrincipal = new JPanel();
        jPanelPrincipal.setSize(700, 500);
        jPanelPrincipal.setBackground(new Color(13, 64, 56));
        jPanelPrincipal.setLayout(null);
        jFramePrincipal.add(jPanelPrincipal);

        jlPelota = new JLabel();
        jlPelota.setBorder(new LineBorder(Color.black));
        jlPelota.setOpaque(true);
        jlPelota.setBackground(Color.WHITE);
        jlPelota.setBounds(333, 215, 20, 20);
        jPanelPrincipal.add(jlPelota);

        jlLinea = new JLabel();
        jlLinea.setOpaque(true);
        jlLinea.setBackground(Color.WHITE);
        jlLinea.setBounds(340, 0, 5, 600);
        jPanelPrincipal.add(jlLinea);

        jlPaletaJugador1 = new JLabel();
        jlPaletaJugador1.setOpaque(true);
        jlPaletaJugador1.setBounds(25, 180, 20, 100);
        jlPaletaJugador1.setBackground(Color.WHITE);
        jPanelPrincipal.add(jlPaletaJugador1);

        jlPaletaJugador2 = new JLabel();
        jlPaletaJugador2.setOpaque(true);
        jlPaletaJugador2.setBounds(650, 180, 20, 100);
        jlPaletaJugador2.setBackground(Color.WHITE);
        jPanelPrincipal.add(jlPaletaJugador2);

        jlMarcador1 = new JLabel("0");
        jlMarcador1.setForeground(Color.white);
        jlMarcador1.setBounds(320,10,10,10);
        jPanelPrincipal.add(jlMarcador1);


        jlMarcador2 = new JLabel("0");
        jlMarcador2.setForeground(Color.white);
        jlMarcador2.setBounds(358,10,10,10);
        jPanelPrincipal.add(jlMarcador2);

        PartidaPong = new Partida(jFramePrincipal,jlPaletaJugador1,jlPaletaJugador2,jlPelota,5);
        PartidaPong.comenzarPartida();

    }
}
