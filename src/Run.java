/*
    Manav Kulshrestha
    Run.java
    5/24/18
*/

import javax.swing.*;
import java.awt.*;

public class Run {
    public static void main(String args[]) {
        JFrame space = new Space();
        BodySystem bs = new BodySystem(50);

        bs.addBody("", 100, 20, 400, 100, 0, 0);
        bs.addBody("", 100, 20, 300, 100, 0, 0);
        space.add(bs);


    }
}