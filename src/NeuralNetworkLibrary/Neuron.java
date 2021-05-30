package NeuralNetworkLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Neuron {
    public Float bias;
    public Float value;
    public ArrayList<Float> weights;

    public Neuron(){
        this.bias = Float.valueOf(new Random().nextFloat() * 2 - 1);
        this.value = Float.valueOf(0);
        this.weights = new ArrayList<>();
    }
    public Neuron(ArrayList<Float> w){
        this.bias = Float.valueOf(new Random().nextFloat() * 2 - 1);
        this.value = Float.valueOf(0);
        this.weights = new ArrayList<>();
        for(float f : w) this.weights.add(Float.valueOf(f));
    }
    public Neuron(Neuron n){
        this.bias = n.bias;
        this.value = n.value;
        this.weights = new ArrayList<>();
        for(float f : n.weights) this.weights.add(Float.valueOf(f));
    }

    public void evaluate(ArrayList<Float> inputs){
        Float result = this.bias;
        Iterator<Float> inputIterator = inputs.iterator();
        Iterator<Float> weightIterator = this.weights.iterator();
        while(inputIterator.hasNext() && weightIterator.hasNext()) result += inputIterator.next() * weightIterator.next();
        this.value = Util.relu(result);
    }
    public void populate(int pop){
        this.weights.clear();
        // TEST: Test with gaussian generation instead
        // for(int i=0; i<pop; i++) this.weights.add(Float.valueOf(new Random().nextGaussian())); // Already between -1 and 1
        for(int i=0; i<pop; i++) this.weights.add(Float.valueOf(new Random().nextFloat() * 2 - 1)); // Originally between 0 and 1
    }

    public String toString(int depth){
        String result = "\t".repeat(depth) + "Neuron(value=" + this.value + ", bias=" + this.bias + ")\n\t" + "\t".repeat(depth);
        int count = 0;
        for(Float w : this.weights) {
            result += w;
            if(++count < this.weights.size()) result += ", ";
        }
        return result + "";
    }
}
