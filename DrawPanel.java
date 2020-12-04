package lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // 3 images
    BufferedImage[] images = new BufferedImage[3];
    
    // To keep track of the cars' positions
    ArrayList<Point> points = new ArrayList<>();
    
    //Moves the cars
    void moveit(int x, int y, int i){
    	points.get(i).x = x ;
    	points.get(i).y = y;  
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);

        try {
        	images[0] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        	images[1] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        	images[2] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        	
        	for (int i = 0 ; i < 3 ; i++) {
            	points.add(new Point());
            }
        	
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0 ; i < 3 ; i++) {
        	g.drawImage(images[i], points.get(i).x, points.get(i).y, null);
        	if (i < 2)
        	points.get(i+1).y = points.get(i).y + 100 ;
        }       
    }
}

