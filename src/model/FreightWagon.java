package model;


public class FreightWagon extends Wagon {

    public FreightWagon(String name) {
        super(name, 2);
    }

    @Override
    public String getShape() {
        return "freight_wagon";
    }
}
