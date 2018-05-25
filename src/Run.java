/*
    Manav Kulshrestha
    Run.java
    5/24/18
*/

import javax.swing.*;

public class Run {
    public static void main(String args[]) {
        JFrame f = new JFrame();

        BodySystem bs = new BodySystem(10, 5);
        bs.addBody(100, 20, 100, 100, 1, 1);
        f.add(bs);

        f.setVisible(true);
        f.setSize(1100, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Gravity Simulator");
    }
}