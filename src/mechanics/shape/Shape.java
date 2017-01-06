package mechanics.shape;

import javafx.scene.canvas.Canvas;

public interface Shape {

    /**
     * Draw this shape.
     * @param canvas The canvas to draw on.
     * @param offset The offset draw offset from the parent and its previous children.
     */
    void draw(Canvas canvas, int offset);

}
