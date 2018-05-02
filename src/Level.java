/*
    Manav Kulshrestha
    Level.java
    4/11/18
*/

public class Level {
    private int winOrbitCount;
    private int orbitCount;
    private System system;
    private double pathHelperLength;

    public Level(int goal, System system, double pathHelperLength) {
        this.orbitCount = 0;
        this.winOrbitCount = goal;
        this.system = system;
        this.pathHelperLength = pathHelperLength;
    }
}