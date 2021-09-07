/** 
 * Date: 2021-09-07
 * File Name: Point.java
 * Author: Viktor Ödman
 */
package vo222dq_assign1;

public class Point {
    /**
     * The X coordinate of the point
     */
    private int x;
    /**
     * The Y coordinate of the point
     */
    private int y;

    /**
     * Intitializes a new Point with a x and y cordinate equal to the passed values.
     * @param x The X coordinate
     * @param y The Y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Intitializes a new Point with a x and y set to 0.
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Check if the passed Point instances coordinates are equal to called instances coordinates 
     * @param p2 A Point instance.
     * @return Return true if the Points are equal
     */
    public boolean isEqualTo(Point p2) {
        return this.x == p2.x && this.y == p2.y;
    }

    /**
     * Checks the distance between the Points coordinates and the passed Points cordinates
     * @param p2 A Point instance
     * @return The distance between the two points.
     */
    public double distanceTo(Point p2) {
        return Math.sqrt((Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2)));
    }

    /**
     * Moves the Points x and y coordinates the passed amount of steps.
     * @param xSteps Steps to move in the x direction.
     * @param ySteps Steps to move in the y direction.
     */
    public void move(int xSteps, int ySteps) {
        this.x += xSteps; 
        this.y += ySteps; 
    }

    /**
     * Moves the Points x and y position to the passed positions
     * @param xPos The x position that the Point will have
     * @param yPos The y position that the Point will have
     */
    public void moveToXY(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
    }
    
    /**
     * Returns a string representation of the Point.
     */
    public String toString() {
        return "(" + this.x + "," + this.y + ")"; 
    }
}
