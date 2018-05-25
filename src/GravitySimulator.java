/*
    Manav Kulshrestha
    GravitySimulator.java
    5/25/18
*/

public class GravitySimulator {
    public static void main(String args[]) {
        Space space = new Space();
        Selector selector = new Selector();
        BodySystem bodySystem = new BodySystem(50);

        Run runner = new Run(selector, space, bodySystem);

        space.setVisible(true);
        selector.setVisible(true);
    }
}