package NeuralNetworkLibrary;

public class Util {
    public static Float relu(Float x){
        return Float.valueOf(Math.max(0, x));
    }
    public static Float sigmoid(Float x){
        return Float.valueOf((float)(1.0/(1+Math.exp(-x))));
    }
}
