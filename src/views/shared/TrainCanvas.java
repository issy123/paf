package views.shared;

import javafx.scene.canvas.Canvas;
import mechanics.shape.ShapeFactory;
import model.Train;
import model.Wagon;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TrainCanvas extends Canvas implements Observer {

    /**
     * The train of this observer.
     */
    private final Train train;

    public TrainCanvas(Train train) {
        super(1000, 300);
        this.train = train;
    }

    @Override
    public void update(Observable o, Object arg) {
        getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
        ShapeFactory.get("train").draw(this, 0);
        List<Wagon> wagons = train.getWagons();
        for(int i = 0; i < wagons.size(); i++) {
            ShapeFactory.get(wagons.get(i).getShape()).draw(this, i);
        }
    }

}
