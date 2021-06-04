import NeuralNetworkLibrary.NeuralNetwork;

public class Car implements Comparable<Car>{
    private static int count = 0;
    public static int VIEW_RANGE = 200;

    public int id;
    public boolean alive;
    public float speed;
    public float orientation;
    public float x;
    public float y;
    public float lastX;
    public float lastY;
    public float totalDistance;
    public float totalDistanceAfterCheckpoint;
    public float totalDistanceLast;
    public int nextCheckpointID;
    public NeuralNetwork nn;

    public Car(){
        this.id = count++;

        this.alive = true;
        this.speed = 5;
        this.orientation = 90;
        this.x = 350;
        this.y = 80;
        this.lastX = 0;
        this.lastY = 0;
        this.totalDistance = 0;
        this.totalDistanceAfterCheckpoint = 0;
        this.totalDistanceLast = 0;
        this.nextCheckpointID = 0;
        this.nn = new NeuralNetwork();
    }
    public Car(Car car){
        this.id = count++;

        this.alive = car.alive;
        this.speed = car.speed;
        this.orientation = car.orientation;
        this.x = car.x;
        this.y = car.y;
        this.lastX = car.lastX;
        this.lastY = car.lastY;
        this.totalDistance = car.totalDistance;
        this.totalDistanceAfterCheckpoint = car.totalDistanceAfterCheckpoint;
        this.totalDistanceLast = car.totalDistanceLast;
        this.nextCheckpointID = car.nextCheckpointID;
        this.nn = new NeuralNetwork(car.nn);
    }

    public void reinitialization(){
        this.alive = true;
        this.speed = 5;
        this.orientation = 90;
        this.x = 350;
        this.y = 80;
        this.lastX = 0;
        this.lastY = 0;
        this.totalDistance = 0;
        this.totalDistanceAfterCheckpoint = 0;
        this.totalDistanceLast = 0;
        this.nextCheckpointID = 0;
    }
    public float fitness(){
        return this.totalDistance;
    }

    @Override
    public int compareTo(Car o) {
        if(this.totalDistance - o.totalDistance < 0) return -1;
        if(this.totalDistance == o.totalDistance) return  0;
        return 1;
    }
    @Override
    public String toString(){
        return "Car(" + ((this.alive) ? "alive" : "dead") +
                ", x=" + this.x + ", y=" + this.y +
                ", speed=" + this.speed + ", orientation=" + this.orientation +
                ", fitness=" + this.totalDistance + ")";
    }
}
