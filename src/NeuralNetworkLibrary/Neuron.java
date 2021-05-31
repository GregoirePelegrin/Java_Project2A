package NeuralNetworkLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Neuron {
    private static int count = 0;

    public int id;
    public Float bias;
    public Float value;
    public ArrayList<Float> weights;

    public Neuron(int _size){
        this.id = Neuron.count++;

        this.bias = new Random().nextFloat() * 2 - 1;
        this.value = (float) 0;
        this.weights = new ArrayList<>();
        this.populate(_size);
    }
    public Neuron(ArrayList<Float> _weights){
        this.id = Neuron.count++;

        this.bias = new Random().nextFloat() * 2 - 1;
        this.value = (float) 0;
        this.weights = new ArrayList<>();
        this.weights.addAll(_weights);
    }
    public Neuron(Neuron _neuron){
        this.id = Neuron.count++;

        this.bias = _neuron.bias;
        this.value = _neuron.value;
        this.weights = new ArrayList<>();
        this.weights.addAll(_neuron.weights);
    }

    public void evaluate(ArrayList<Float> _inputs){
        Float result = this.bias;
        Iterator<Float> inputIterator = _inputs.iterator();
        Iterator<Float> weightIterator = this.weights.iterator();
        while(inputIterator.hasNext() && weightIterator.hasNext())
            result += inputIterator.next() * weightIterator.next();
        this.value = Util.relu(result);
    }
    public void populate(int _pop){
        this.weights.clear();
        // TEST: Test with gaussian generation instead
        // for(int i=0; i<pop; i++) this.weights.add(Float.valueOf(new Random().nextGaussian())); // Already between -1 and 1
        for(int i=0; i<_pop; i++) this.weights.add(new Random().nextFloat() * 2 - 1); // Originally between 0 and 1
    }

    public String toString(int _depth){
        String result = "\t".repeat(_depth) + "Neuron(id=" + this.id + ", value=" + this.value + ", bias=" + this.bias + ")\n\t" + "\t".repeat(_depth);
        if(this.weights.size() == 0) return result += "None";
        int count = 0;
        for(Float w : this.weights) {
            result += w;
            if(++count < this.weights.size()) result += ", ";
        }
        return result;
    }
}
