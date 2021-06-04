package NeuralNetworkLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<Integer> dimensions = new ArrayList<>(Arrays.asList(4, 5, 5, 4));

    public static Double relu(Double x){
        return Math.max(0, x);
    }
    public static Double sigmoid(Double x){
        return 1.0 / (1 + Math.exp(-x));
    }
}
