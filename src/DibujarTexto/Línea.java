package DibujarTexto;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.swing.*;

public class Línea extends JFrame {
    // Inicializamos una ventana.
    public Línea() {
        super("Java2D - Texto");

        setSize(500, 700);
        setVisible(true);
        setResizable(false);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        //  Dibujar una línea de texto y modificar
        g2.setColor(Color.blue);
        g2.setFont(new Font("Serif", Font.BOLD, 24));
        g2.drawString("Dibujando con drawString()", 10, 100);
        
        FontRenderContext frc = g2.getFontRenderContext();
        Font f = new Font("Arial", Font.PLAIN, 15);
        TextLayout tl = new TextLayout("Dibujando con TextLayout()", f, frc);
        g2.setColor(Color.black);
        tl.draw(g2, 10, 200);
    } 

    public static void main(String args[]) {
        Línea application = new Línea();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
