/*
    Manav Kulshrestha
    Body.java
    4/9/18
*/

public class Body {
//    private final double G = .00000000006674;//TODO probably use a much larger G
    private final double G = 6.674;
    private String label;
    public double xPosition;
    public double yPosition;
    private double iVector;
    private double jVector;
    private double mass;
    private double radius;

    public Body(double m, double r, double x, double y, double i, double j) {
        this.xPosition = x;
        this.yPosition = y;
        this.iVector = i;
        this.jVector = j;
        this.mass = m;
        this.radius = r;
    }

//    public String getLabel() {
//        return this.label;
//    }
//
//    public void setLabel(String newLabel) {
//        this.label = newLabel;
//    }

    public double getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(double newXPosition) {
        this.xPosition = newXPosition;
    }

    public double getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(double newYPosition) {
        this.xPosition = newYPosition;
    }

    public double getIVector() {
        return this.iVector;
    }

    public void setIVector(double newIVector) {
        this.iVector = newIVector;
    }

    public double getJVector() {
        return this.jVector;
    }

    public void setJVector(double newJVector) {
        this.jVector = newJVector;
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double newMass) {
        this.mass = newMass;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public double getAbsoluteDistance(Body body) {
        return Math.sqrt(Math.pow(this.getXDistance(body), 2) + Math.pow(this.getYDistance(body), 2));
    }

    public double getXDistance(Body body) {
        return this.xPosition-body.getXPosition();
    }

    public double getYDistance(Body body) {
        return this.yPosition-body.getYPosition();
    }

    public void accelerateByGravity(Body body) {
        double h = this.getAbsoluteDistance(body), x = this.getXDistance(body), y = this.getYDistance(body);
        double a = G*body.getMass()/Math.pow(h, 2);

        // x+ means this is on the right. x- means this is on the left.
        // y+ means this is on the bottom. y- means this on the top.

        // y=0 means side by side. x=0 means up down

        double sin = y/h;
        double cos = x/h;

        if(x == 0) {
            this.jVector += (y > 0) ? a : -a;
        } else if(y == 0) {
            this.iVector += (x > 0) ? -a : a;
        } else {
            this.iVector += -a*cos;
            this.jVector += -a*sin;
        }
    }

    public void move() {
        this.xPosition += iVector;
        this.yPosition += jVector;
    }

    public boolean collision(Body body) {
        return (this.getAbsoluteDistance(body) < this.getRadius()+body.getRadius());
    }

    public void combine(Body body) {
        double bMass = body.getMass();
        double bRadius = body.getRadius();
        double newMass = this.mass+bMass;

        this.iVector = ((bMass*body.getIVector())+(this.mass*this.iVector))/(newMass);
        this.jVector = ((bMass*body.getJVector())+(this.mass*this.jVector))/(newMass);
        this.mass = newMass;
        this.radius = Math.sqrt(bRadius*bRadius + this.radius*this.radius);
        this.xPosition = (this.xPosition+body.getXPosition())/2;
        this.yPosition = (this.yPosition+body.getYPosition())/2;

        body.zero();

    }

    public void zero() {
        this.mass = 0;
        this.radius = 0;
        this.iVector = 0;
        this.jVector = 0;
        this.xPosition = -10000;
        this.yPosition = -10000;
    }

//    public abstract void draw();
//
//    public abstract Body copy();
//
//    public abstract void remove();
}