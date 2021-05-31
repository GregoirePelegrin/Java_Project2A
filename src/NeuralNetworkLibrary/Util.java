package NeuralNetworkLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<Integer> dimensions = new ArrayList<>(Arrays.asList(1, 2));

    public static Float relu(Float x){
        return Float.valueOf(Math.max(0, x));
    }
    public static Float sigmoid(Float x){
        return Float.valueOf((float)(1.0/(1+Math.exp(-x))));
    }
}
