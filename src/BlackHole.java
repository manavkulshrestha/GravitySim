/*
    Manav Kulshrestha
    BlackHole.java
    5/11/18
*/

public class BlackHole extends Body{
    public BlackHole(String label, double mass, double radius, double x, double y) {
        super(label, mass, radius, x, y, 0, 0);
    }

    @Override
    public Body copy() {
        return new BlackHole(this.getLabel(), this.getMass(), this.getRadius(), this.getXPosition(), this.getYPosition());
    }

    @Override
    public void remove() {

    }

    @Override
    public void draw() {

    }
}