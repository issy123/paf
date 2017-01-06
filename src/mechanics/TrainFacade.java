package mechanics;

import model.Train;
import model.Wagon;

import java.util.*;

public class TrainFacade extends Observable {

    /**
     * The singleton object.
     */
    private static final TrainFacade instance = new TrainFacade();

    /**
     * A map holding all trains in this application.
     */
    private final ArrayList<Train> trains = new ArrayList<Train>();

    /**
     * A map holding all temporarily unassociated created wagons.
     */
    private final Map<String, Wagon> wagons = new HashMap<>();

    private TrainFacade() {
        /*
         * Empty
         */
    }
    public static TrainFacade getInstance(){
        return instance;
    }
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    public Train createTrain(String name) throws TrainFacadeException {
        System.out.println("CREATE TRAIN");
        if (getTrain(name) != null) {
            throw new TrainFacadeException("There is already a train with this name, please choose another name.");
        }
        Train train = new Train(name);
        trains.add(train);

        notifyObservers();
        return train;
    }
    public Train getTrain(String name){
        for(Train train : trains){
            if(train.getName().equals(name)){
                return train;
            }
               //something here
        }
        return null;
    }
    public Train removeTrain(String name){
        Train train = getTrain(name);
        trains.remove(train);
        
        return train;
    }

    public void addWagon(String wagonName, String trainName) throws TrainFacadeException {
        System.out.println("ADD WAGON");
        Train train = getTrain(trainName);
        if (train == null) {
            throw new TrainFacadeException("The name of the train you tried to add a wagon to, doesn't exist.");
        }
        if (train.get(wagonName) != null) {
            throw new TrainFacadeException("There is already a wagon named " + wagonName + " in train " + trainName + ".");
        }
        Wagon wagon = wagons.remove(wagonName);
        if (wagon == null) {
            throw new TrainFacadeException("The wagon you tried to add to train " + trainName + " doesn't exist.");
        }
        train.add(wagon);
        notifyObservers();
    }

    public int getTrainSeats(String name) throws TrainFacadeException {
        System.out.println("GET TRAIN SEATS");
        Train train = getTrain(name);
        if (train == null) {
            throw new TrainFacadeException("The name of the train you tried to count the seats of, doesn't exist.");
        }
        return train.getSeats();
    }

    public Train deleteTrain(String name) throws TrainFacadeException {
        System.out.println("DELETE TRAIN");
        Train train = removeTrain(name);
        if (train == null) {
            throw new TrainFacadeException("The train you tried to delete doesn't exist.");
        }
        notifyObservers();
        return train;
    }

    public Wagon createWagon(Wagon wagon) throws TrainFacadeException {
        System.out.println("CREATE WAGON");
        if (wagons.get(wagon.getName()) != null) {
            throw new TrainFacadeException("There is already a wagon with this name.");
        }
        wagons.put(wagon.getName(), wagon);
        notifyObservers();
        return wagon;
    }

    public Wagon createWagon(String name, int seats) throws TrainFacadeException {
        System.out.println("CREATE WAGON WITH SEATS");
        if (wagons.get(name) != null) {
            throw new TrainFacadeException("There is already a wagon with this name.");
        }
        Wagon wagon = new Wagon(name, seats);
        wagons.put(name, wagon);
        notifyObservers();
        return wagon;
    }

    public int getWagonSeats(String name) throws TrainFacadeException {
        Wagon wagon = wagons.get(name);
        if (wagon == null) {
            throw new TrainFacadeException("The name of the wagon you tried to count the seats of, doesn't exist or is assigned to a train.");
        }
        return wagon.getSeats();
    }

    public Wagon deleteWagon(String trainName, String wagonName) throws TrainFacadeException {
        System.out.println("DELETE WAGON");
        Train train = getTrain(trainName);
        if (train == null) {
            throw new TrainFacadeException("The train " + trainName + " you tried to delete a wagon from, doesn't exist.");
        }
        Wagon wagon = train.remove(wagonName);
        if (wagon == null) {
            throw new TrainFacadeException("Wagon " + wagonName + " in train " + trainName + " doesn't exist.");
        }
        notifyObservers();
        return wagon;
    }
    public ArrayList<Train> getTrains(){
        return this.trains;
    }
    public Map<String, Wagon> getWagons(){
        return this.wagons;
    }
}
