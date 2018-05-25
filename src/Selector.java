/*
    Manav Kulshrestha
    Selector.java
    5/16/18
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Selector extends JFrame {
    private JPanel main, mr;
    private JLabel nameLabel, massLabel, radiusLabel, iVectorLabel, jVectorLabel, xPosLabel, yPosLabel;
    private JTextField nameText, massText, radiusText, iVectorText, jVectorText, xPosText, yPosText;
    private JSlider massSlider, radiusSlider;
    private JRadioButton Projectile, Stationary;
    private JButton coords, place;
    public int count;
    private String[] info;

    public static void main(String args[]) {
        Selector selector = new Selector();
    }

    public Selector() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        info = new String[5];

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Body selector");
        this.setVisible(true);

        //Panel stuff
        main = new JPanel();
        main.setLayout(new GridBagLayout());

        xPosLabel = new JLabel("X Position:");
        addComp(main, xPosLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        xPosText = new JTextField(30);
        xPosText.setText("0");
        addComp(main, xPosText, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        yPosLabel = new JLabel("Y Position:");
        addComp(main, yPosLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        yPosText = new JTextField(30);
        yPosText.setText("0");
        addComp(main, yPosText, 1, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        coords = new JButton("Pull Coordiantes");
        addComp(main, coords, 1, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

        mr = new JPanel();
        mr.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        massLabel = new JLabel("Mass: 1");
        mr.add(massLabel);
        massSlider = new JSlider(1, 499, 1);
        ListenForMassSlider listenForMassSlider = new ListenForMassSlider();
        massSlider.addChangeListener(listenForMassSlider);
        mr.add(massSlider);

        radiusLabel = new JLabel("Radius: 1");
        mr.add(radiusLabel);
        radiusSlider = new JSlider(1, 99, 1);
        ListenForRadiusSlider listenForRadiusSlider = new ListenForRadiusSlider();
        radiusSlider.addChangeListener(listenForRadiusSlider);
        mr.add(radiusSlider);

        addComp(main, mr, 0, 3, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        iVectorLabel = new JLabel("I Vector:");
        addComp(main, iVectorLabel, 0, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        iVectorText = new JTextField(30);
        addComp(main, iVectorText, 1, 4, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        jVectorLabel = new JLabel("J Vector:");
        addComp(main, jVectorLabel, 0, 5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        jVectorText = new JTextField(30);
        addComp(main, jVectorText, 1, 5, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        place = new JButton("Place");
        addComp(main, place, 1, 6, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

        Box typeBox = Box.createVerticalBox();

        Projectile = new JRadioButton("Projectile", true);
        ListenForProjectileRadio listenForProjectileRadio = new ListenForProjectileRadio();
        Projectile.addItemListener(listenForProjectileRadio);

        Stationary = new JRadioButton("Stationary");

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(Projectile);
        typeGroup.add(Stationary);
        typeBox.add(Projectile);
        typeBox.add(Stationary);
        typeBox.setBorder(BorderFactory.createTitledBorder("Type"));
        addComp(main, typeBox, 3, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(main);
        this.pack();
        main.setVisible(true);
        this.show();
    }

    private void addComp(JPanel panel, JComponent comp, int x, int y, int compWidth, int compHeight, int place, int stretch) {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = x;
        gridConstraints.gridy = y;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;
        panel.add(comp, gridConstraints);
    }

    private class ListenForMassSlider implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == massSlider) {
                massLabel.setText("Mass: "+massSlider.getValue());
            }
        }
    }

    private class ListenForRadiusSlider implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == radiusSlider) {
                radiusLabel.setText("Radius: "+radiusSlider.getValue());
            }
        }
    }

    private class ListenForProjectileRadio implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            boolean selected = e.getStateChange() == ItemEvent.SELECTED;
            iVectorText.setText("0");
            jVectorText.setText("0");
            iVectorText.setEnabled(selected);
            jVectorText.setEnabled(selected);
        }
    }

    public void addPlaceListener(ActionListener listenerForPlace) {
        place.addActionListener(listenerForPlace);
    }

    public void addCoordListener(ActionListener listenerForCoords) {
        coords.addActionListener(listenerForCoords);
    }

//    public String getNameLabel() {
//        return nameText.getName();
//    }

    public void setCoords(int x, int y) {
        xPosText.setText(""+x);
        yPosText.setText(""+y);
    }

    public int getMass() {
        return massSlider.getValue();
    }

    public int getRadius() {
        return radiusSlider.getValue();
    }

    public int getXPos() {
        return Integer.parseInt(xPosText.getText());
    }

    public int getYPos() {
        return Integer.parseInt(yPosText.getText());
    }

    public int getIVector() {
        return Integer.parseInt(iVectorText.getText());
    }

    public int getjVector() {
        return Integer.parseInt(jVectorText.getText());
    }

    public String[] getInfo() {
        return info;
    }
}
