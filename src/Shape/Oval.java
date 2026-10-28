package Shape;

import java.awt.geom.*;

/**
 * An oval that can be manipulated and that draws itself on a canvas.
 */
public class Oval extends SimpleShape
{   

    private int width;
    private int height;
    
    /**
     * Create a new oval at default position with default color.
     */
    public Oval()
    {
        super();
        width = 50;
        height = 30;
    }
    
    /**
     * Change the shape's size.
     */
    public void changeSize(int w, int h) {
        width = w;
        height = h;
        draw();
    }

    /**
     * Draw the oval with current specifications on screen.
     */
    public void draw()
    {
        if(isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(), new Ellipse2D.Double(getxPosition(), getyPosition(), 
                                                          width, height));
            canvas.wait(10);
        }
    }
}
