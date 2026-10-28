package Shape;

/**
 * This class contains the fields and methods common to all simple shapes.
 */
public class SimpleShape
{
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new shape at default position with default color.
     */
    public SimpleShape()
    {
        xPosition = 60;
        yPosition = 50;
        color = "red";
        isVisible = false;
    }

    /**
     * Returns this shape's color.
     * @returns color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Returns this shape's x position.
     * @returns x position
     */
    public int getxPosition() {
        return xPosition;
    }
    
    /**
     * Returns this shape's y position.
     * @return y position
     */
    public int getyPosition() {
        return yPosition;
    }
    
    /**
     * Returns true if this shape is visible.
     * @returns true if visible
     */
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * Make this shape visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this shape invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the shape a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the shape a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }
   
    /**
     * Moves the shape in a diagonal direction the specified number of pixels.
     * @param distance the number of pixels to move the shape
     */
    public void moveDiagonal(int distance) {
        moveHorizontal(distance);
        moveVertical(distance);
    }
    
    /**
     * Slowly moves the shape in a diagonal direction the specified number of pixels.
     * @param distance the number of pixels to move the shape.
     * @param xDirection the direction along the x axis to move the shape.
     * @param yDirection the direction along the y axis to move the shape.
     */
    public void slowMoveDiagonal(int distance, int xDirection, int yDirection) {
        int deltax = 1;
        int deltay = 1;
        
        if (xDirection < 0) {
            deltax = -1;
        }
        if (yDirection < 0) {
            deltay = -1;
        }
        
        for(int i=0; i<distance; i++) {
            xPosition += deltax;
            yPosition += deltay;
            draw();
        }
    }

    /**
     * Move the shape a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the shape a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the shape horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the shape vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the shape horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta = 1;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the shape vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta = 1;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    
    /**
     * Empty method because there's nothing to draw!
     * (This method needs to be here because other methods in the class
     * try to call it.)
     */
    public void draw()
    {
    }
    
    /**
     * Erase the shape on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
