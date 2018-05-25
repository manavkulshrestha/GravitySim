/*
    Manav Kulshrestha
    Screen.java
    5/1/18
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Space extends JFrame implements MouseListener{
//    JPanel panel;
//    JLabel coords;
    private int xCoord;
    private int yCoord;

    public Space() {
        this.setVisible(true);
        this.setSize(1100, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gravity Simulator");

        xCoord = 0;
        yCoord = 0;

//        panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        coords = new JLabel("(X, Y) = ");
//        this.add(panel);

        this.addMouseListener(this);
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xCoord = e.getX();
        yCoord = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.printf("Pressed: X=%s Y=%s\n", e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.printf("Released: X=%s Y=%s\n", e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.printf("Entered: X=%s Y=%s\n", e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.printf("Exited: X=%s Y=%s\n", e.getX(), e.getY());
    }
}