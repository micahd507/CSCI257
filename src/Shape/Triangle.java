package Shape;

import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 */
public class Triangle extends SimpleShape
{
    private int height;
    private int width;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle()
    {
        super();
        height = 30;
        width = 40;
    }

    /**
     * Change the shape's size.
     */
    public void changeSize(int h, int w) {
        height = h;
        width = w;
        draw();
    }
    
    /**
     * Draw the triangle with current specifications on screen.
     */
    public void draw()
    {
        if(isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { getxPosition(), getxPosition() + (width/2), getxPosition() - (width/2) };
            int[] ypoints = { getyPosition(), getyPosition() + height, getyPosition() + height };
            canvas.draw(this, getColor(), new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }
}
