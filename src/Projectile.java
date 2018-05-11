/*
    Manav Kulshrestha
    Projectile.java
    5/11/18
*/

public class Projectile extends Body{
    public Projectile(String label, double mass, double radius, double x, double y, double i, double j) {
        super(label, mass, radius, x, y, i, j);
    }

    @Override
    public Body copy() {
        return new Projectile(this.getLabel(), this.getMass(), this.getRadius(), this.getXPosition(), this.getYPosition(), this.getIVector(), this.getJVector());
    }

    @Override
    public void remove() {

    }

    @Override
    public void draw() {

    }
}