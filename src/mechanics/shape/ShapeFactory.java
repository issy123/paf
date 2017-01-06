package mechanics.shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    /**
     * A map of registered shape implementations.
     */
    private static final Map<String, Shape> SHAPES = new HashMap<>();

    private ShapeFactory() {
        /*
         * Empty
         */
    }

    /**
     * Register a shape.
     * @param name The name.
     * @param shape The shape.
     * @return If we have registered the shape with success.
     */
    public static boolean register(String name, Shape shape) {
        if (SHAPES.get(name) != null) {
            return false;
        }
        SHAPES.put(name, shape);
        return true;
    }

    /**
     * Get a shape by its name.
     * @param name The name of the shape.
     * @return The shape.
     */
    public static Shape get(String name) {
        return SHAPES.get(name);
    }

}
