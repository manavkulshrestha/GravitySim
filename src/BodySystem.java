/*
    Manav Kulshrestha
    Bodies.java
    5/24/18
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class BodySystem extends JPanel implements ActionListener{
    private Timer timer;
    ArrayList<Body> bodies;

    public BodySystem(int delay) {
         timer = new Timer(delay, this);
        bodies = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D[] circles = new Ellipse2D[bodies.size()];
        for(int i=0; i<circles.length; i++) {
            double d = bodies.get(i).getRadius()*2;
            circles[i] = new Ellipse2D.Double(bodies.get(i).getXPosition(), bodies.get(i).getYPosition(), d, d);
            g2.fill(circles[i]);
        }

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        int size = bodies.size();

        //collision check
        for(int i=0; i<size; i++)
            for(int j=i+1; j<size; j++)
                if(bodies.get(i).collision(bodies.get(j)))
                    bodies.get(i).combine(bodies.get(j));

        //removing zeros
        for(int i=0; i<bodies.size(); i++)
            if(bodies.get(i).getMass() == 0 || bodies.get(i).getXPosition() < -10 || bodies.get(i).getYPosition() < -10)
                bodies.remove(i);

        size = bodies.size();

        //accelerate
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(i != j)
                    bodies.get(i).accelerateByGravity(bodies.get(j));

        //move
        for(Body b: bodies)
            b.move();

        repaint();
    }

    public void addBody(double m, double r, double x, double y, double i, double j) {
        bodies.add(new Body(m, r, x, y, i, j));
    }
}