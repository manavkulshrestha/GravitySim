/*
    Manav Kulshrestha
    Body.java
    4/9/18
*/

public class Body {
//    private final double G = .00000000006674;//TODO probably use a much larger G
    private final double G = 6674;
    private String label;
    public double xPosition;
    public double yPosition;
    private double iVector;
    private double jVector;
    private double mass;
    private double radius;

    public Body(String label, double m, double r, double x, double y, double i, double j) {
        this.label = label;
        this.xPosition = x;
        this.yPosition = y;
        this.iVector = i;
        this.jVector = j;
        this.mass = m;
        this.radius = r;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String newLabel) {
        this.label = newLabel;
    }

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

        double sin = y/h;
        double cos = x/h;

        if(x == 0) {
            this.jVector += a;
        } else if(y == 0) {
            this.iVector += a;//            ., or ,.
        } else if(x > 0) {//body this
            if(y > 0) {//this|body
                this.iVector += -a*cos;//       .
                this.jVector += -a*sin;//   ,
            } else if(y < 0) {//body|this
                this.iVector += -a*cos;//   ,
                this.jVector += a*sin;//        .
            }
        } else if(x < 0) {//this body
            if(y > 0) {//this|body
                this.iVector += a*cos;//    .
                this.jVector += -a*sin;//       ,
            } else if(y < 0) {//body|this
                this.iVector += a*cos;//        ,
                this.jVector += a*sin;//    .
            }
        }
    }

    public void move() {
        this.xPosition += iVector;
        this.yPosition += jVector;
    }

    public boolean collision(Body body) {
        return (this.getXDistance(body) <= (this.radius+body.radius));
    }

//    public abstract void draw();
//
//    public abstract Body copy();
//
//    public abstract void remove();
}