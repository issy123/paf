package mechanics.shape.shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import mechanics.shape.Shape;

public class PassengerWagonShape implements Shape {

    @Override
    public void draw(Canvas canvas, int offset) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.drawImage(new Image("file:resources/img/GreenWagonTrans.png", 150, 150, true, true), 150 + (offset * 150), 55);
        context.fillText("Passenger wagon", 180 + (offset * 150), 155);
    }

}
