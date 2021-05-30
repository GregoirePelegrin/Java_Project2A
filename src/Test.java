import NeuralNetworkLibrary.Layer;
import NeuralNetworkLibrary.Neuron;
import NeuralNetworkLibrary.Util;

public class Test {
    public static void main(String[] args) {
        Layer l1 = new Layer(5);
        l1.populate(2);
        Layer l2 = new Layer(l1);
        System.out.println(l1.toString(0));
        System.out.println(l2.toString(0));
        l2.populate(2);
        System.out.println(l1.toString(0));
        System.out.println(l2.toString(0));
    }
}
