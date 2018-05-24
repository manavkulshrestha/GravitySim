/*
    Manav Kulshrestha
    Selector.java
    5/16/18
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Selector extends JFrame {
    private JPanel main, mr;
    private JLabel nameLabel, massLabel, radiusLabel, iVectorLabel, jVectorLabel;
    private JTextField nameText, massText, radiusText, iVectorText, jVectorText;
    private JSlider massSlider, radiusSlider;
    private JRadioButton Projectile, Stationary;
    private JButton save;
    public int count;
    private String[] info;

    public static void main(String args[]) {
        Selector selector = new Selector();
        String[] info = selector.getInfo();
        System.out.print(info);
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

        nameLabel = new JLabel("Name:");
        addComp(main, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        nameText = new JTextField(30);
        addComp(main, nameText, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

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

        addComp(main, mr, 0, 1, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        iVectorLabel = new JLabel("I Vector:");
        addComp(main, iVectorLabel, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        iVectorText = new JTextField(30);
        addComp(main, iVectorText, 1, 2, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        jVectorLabel = new JLabel("J Vector:");
        addComp(main, jVectorLabel, 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        jVectorText = new JTextField(30);
        addComp(main, jVectorText, 1, 3, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        save = new JButton("Save");
        addComp(main, save, 1, 4, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

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

    private class ListenForSave implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == save) {
                info[0] = ""+nameText.getText();
                info[1] = ""+massSlider.getValue();
                info[2] = ""+radiusSlider.getValue();
                info[3] = ""+iVectorText.getText();
                info[4] = ""+jVectorText.getText();
            }
        }
    }

    public String[] getInfo() {
        return info;
    }
}
