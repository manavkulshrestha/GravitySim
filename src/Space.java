/*
    Manav Kulshrestha
    Screen.java
    5/1/18
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Space extends JFrame {
    public static void main(String args[]) {
        new Space();
    }

    public Space() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        this.setSize(400, 400);

        Dimension dim = toolkit.getScreenSize();
        int xPosition = (dim.width/2)-(this.getWidth()/2);
        int yPosition = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPosition, yPosition);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gravity Sim");
        this.setVisible(true);

        //Panel stuff
        JPanel panel1 = new JPanel();
        panel1.addMouseListener(new ListenForMouse());
        panel1.setBackground(Color.WHITE);
        panel1.setVisible(true);
        this.add(panel1);
        this.show();
    }

    private class ListenForMouse implements MouseListener{
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         */
        public void mouseClicked(MouseEvent e) {
            System.out.println("X: "+e.getX()+",  Y: "+e.getY());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         */
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been released on a component.
         */
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         */
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * Invoked when the mouse exits a component.
         */
        public void mouseExited(MouseEvent e) {

        }
    }
}