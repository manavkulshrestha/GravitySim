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
//    final int M = 0, R = 1, POS_X = 2, POS_Y = 3, VEL_I = 4, VEL_J = 5;
//    double[][] bodies;
//    int bodyCount;

    ArrayList<Body> bodies;
    public BodySystem(int delay) {
//         bodies = new double[totalBodyCount][6];
         timer = new Timer(delay, this);
//         bodyCount = 0;
        bodies = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        Ellipse2D[] circles = new Ellipse2D[bodies.length];
//        for(int i=0; i<bodyCount; i++) {
//            double d = bodies[i][R]*2;
//            circles[i] = new Ellipse2D.Double(bodies[i][POS_X], bodies[i][POS_Y], d, d);
//            g2.fill(circles[i]);
//        }

        Ellipse2D[] circles = new Ellipse2D[bodies.size()];
        for(int i=0; i<circles.length; i++) {
            double d = bodies.get(i).getRadius()*2;
            circles[i] = new Ellipse2D.Double(bodies.get(i).getXPosition(), bodies.get(i).getYPosition(), d, d);
            g2.fill(circles[i]);
        }

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
//        int size = bodies.size();

//        for(int i=0; i<size; i++) {
//            for(int j=0; j<size; j++) {
//                if(i == j)
//                    break;
//                bodies.get(i).accelerateByGravity(bodies.get(j));
//            }
//        }

        for(Body b: bodies)
            b.move();

//        for(int i=0; i<bodyCount; i++) {
//            bodies[i][POS_X] += bodies[i][VEL_I];
//            bodies[i][POS_Y] += bodies[i][VEL_J];
//        }

        repaint();
    }

    /**
     *
     * @param parameters:
     *                  M, R, POS_X, POS_Y, VEL_I, VEL_J;
     */
    public void addBody(String label, double m, double r, double x, double y, double i, double j) {
//    public void addBody(double... parameters) {
//        for(int parameter=0; parameter<6; parameter++)
//            bodies[bodyCount][parameter] = parameters[parameter];
//        bodyCount++;
        bodies.add(new Body(label, m, r, x, y, i, j));
    }
}