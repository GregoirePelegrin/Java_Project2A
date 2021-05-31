import NeuralNetworkLibrary.Layer;
import NeuralNetworkLibrary.NeuralNetwork;
import NeuralNetworkLibrary.Neuron;
import NeuralNetworkLibrary.Util;

public class Test {
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork();
        NeuralNetwork nn2 = new NeuralNetwork(nn);
        System.out.println(nn.toString(0));
        System.out.println(nn2.toString(0));
    }
}
