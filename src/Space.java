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
        Space s = new Space();
//        BodySystem bs = new BodySystem();
//        s.add(bs);
        s.setVisible(true);
    }

    public Space() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        this.setSize(1100, 600);

        Dimension dim = toolkit.getScreenSize();
        int xPosition = (dim.width/2)-(this.getWidth()/2);
        int yPosition = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPosition, yPosition);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gravity Sim");


        //Panel stuff
//        JPanel panel1 = new JPanel();
//        panel1.addMouseListener(new ListenForMouse());
//        panel1.setBackground(Color.WHITE);

//        bs = new BodySystem();
//        this.add(bs);

        this.setVisible(true);
    }

    private class ListenForMouse implements MouseListener{
        private int pressX;
        private int pressY;
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
            this.pressX = e.getX();
            this.pressY = e.getY();
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