package DibujarTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zocket
 */
public class Múltiples extends JFrame {

    private static final Hashtable mapa = new Hashtable();

    private static AttributedString párrafo;

    static {
        mapa.put(TextAttribute.FONT, Font.getFont("Serif",new Font("Serif", Font.ITALIC,40)));
        párrafo = new AttributedString(
                "Pensaba que te había olvidado,"
                + "pero pusieron la canción. "
                + "Si tu novio no te m**a el c**o, "
                + "para eso que no m**e.",
                mapa);

    }

    // Inicializamos una ventana.
    public Múltiples() {
        super("Java2D - Texto");
        super.setBackground(Color.white);
        PanelLíneas panel = new PanelLíneas();
        add(panel, BorderLayout.CENTER);
    }

    class PanelLíneas extends JPanel {

        private LineBreakMeasurer lm;
        private int ini;
        private int fin;

        public PanelLíneas() {
            AttributedCharacterIterator aci = párrafo.getIterator();
            ini = aci.getBeginIndex();
            fin = aci.getEndIndex();
            lm = new LineBreakMeasurer(aci, new FontRenderContext(null, false, false));
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            TextLayout tl;
            Dimension d = getSize();
            float al = (float)d.width;
            float pintarY = 0;
            float pintarX;
            lm.setPosition(ini);
            while(lm.getPosition()<fin){
                tl = lm.nextLayout(al);
                pintarY += tl.getAscent();
                if (tl.isLeftToRight()) {
                    pintarX = 0;
                } else {
                    pintarX = al - tl.getAdvance();
                }
                g2.setColor(Color.blue);
                tl.draw(g2, pintarX, pintarY);
                pintarY += tl.getDescent()+ tl.getLeading();
            }
        }
    }
    public static void main(String[] args) {
        Múltiples m = new Múltiples();
        m.setSize(new Dimension(800,400));
        m.setDefaultCloseOperation(EXIT_ON_CLOSE);
        m.setVisible(true);
    }
}
