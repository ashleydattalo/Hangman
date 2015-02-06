import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.util.Random;
import java.awt.Font;


public class HangmanFigure extends JPanel {
    
    private int guesses;

    public HangmanFigure() {
        super();
        guesses = 0;
        setPreferredSize(new Dimension(300, 300));
        setOpaque(true);
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        Random rnd = new Random();
        int colorColor1 = 0;
        int colorColor2 = 0;
        int colorColor3 = 0;
        
        // base
        if(guesses > 0) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(1, 299, 299, 299);
        }
        
        // right wall
        if(guesses > 1) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(299, 299, 299, 1);
        }
        
        // top line
        if(guesses > 2) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 1, 299, 1);
        }
        
        // hanging line
        if(guesses > 3) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 1, 150, 70);
        }
        
        // face
        if(guesses > 4) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawOval(150-25, 70, 50, 50);
        }
        
        // body
        if(guesses > 5) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 120, 150, 200);
        }
        
        // left hand
        if(guesses > 6) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 150, 110, 140);
        }
        
        // right hand
        if(guesses > 7) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 150, 190, 140);
        }
        
        // left leg
        if(guesses > 8) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 200, 120, 250);
        }
        
        // right leg
        if(guesses > 9) {
            colorColor1 = rnd.nextInt(250);
            colorColor2 = rnd.nextInt(250);
            colorColor3 = rnd.nextInt(250);
            Color newColor = new Color(colorColor1, colorColor2, colorColor3);
            g.setColor(newColor);
            g.drawLine(150, 200, 180, 250);
        }
    }
    
    public void set() {
        guesses++;
        paintComponent(getGraphics());
    }
    
}