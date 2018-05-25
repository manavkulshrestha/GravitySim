/*
    Manav Kulshrestha
    Run.java
    5/24/18
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run {
    private Selector selector;
    private Space space;
    private BodySystem bodySystem;

    public Run(Selector se, Space sp, BodySystem bs) {
        selector = se;
        space = sp;
        bodySystem = bs;

        space.add(bs);

        selector.addPlaceListener(new PlaceListener());
        selector.addCoordListener(new CoordsListener());
    }

    class PlaceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bodySystem.addBody(selector.getMass(), selector.getRadius(), selector.getXPos(), selector.getYPos(), selector.getIVector(), selector.getjVector());
        }
    }

    class CoordsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selector.setCoords(space.getXCoord(), space.getYCoord());
        }
    }
}