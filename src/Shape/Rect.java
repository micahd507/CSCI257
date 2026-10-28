package Shape;

import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 */
public class Rect extends SimpleShape
{

    private int length;
    private int width;
    
    /**
     * Create a new rectangle at default position with default color.
     */
    public Rect()
    {
        super();
        length = 40;
        width = 20;
    }

    /**
     * Change the shape's size.
     */
    public void changeSize(int l, int w) {
        length = l;
        width = w;
        draw();
    }
    
    /**
     * Draw the rectangle with current specifications on screen.
     */
    public void draw()
    {
        if(isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(),
                        new Rectangle(getxPosition(), getyPosition(), length, width));
            canvas.wait(10);
        }
    }
}
