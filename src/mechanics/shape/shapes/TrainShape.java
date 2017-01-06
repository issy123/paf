package mechanics.shape.shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import mechanics.shape.Shape;

public class TrainShape implements Shape {

    @Override
    public void draw(Canvas canvas, int offset) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.drawImage(new Image("file:resources/img/TrainLeftTrans.png", 150, 150, true, true), 0, 0);
    }

}
