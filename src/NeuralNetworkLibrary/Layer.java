package NeuralNetworkLibrary;

import java.util.ArrayList;
import java.util.Iterator;

public class Layer {
    private static int count = 0;

    public int id;
    public ArrayList<Neuron> neurons;
    public int sizePrec;
    public int size;

    public Layer(int _sizePrec, int _size){
        this.id = Layer.count++;

        this.sizePrec = _sizePrec;
        this.size = _size;
        this.neurons = new ArrayList<>();
        for(int i=0; i<this.size; i++) this.neurons.add(new Neuron(this.sizePrec));
    }
    public Layer(ArrayList<ArrayList<Float>> _weights){
        this.id = Layer.count++;

        this.size = _weights.size();
        this.neurons = new ArrayList<>();
        for(ArrayList<Float> weights : _weights)
            this.neurons.add(new Neuron(weights));
    }
    public Layer(Layer _layer){
        this.id = Layer.count++;

        this.sizePrec = _layer.sizePrec;
        this.size = _layer.size;
        this.neurons = new ArrayList<>();
        for(Neuron neuron : _layer.neurons)
            this.neurons.add(new Neuron(neuron));
    }

    public void assign(ArrayList<Float> _values){
        Iterator<Neuron> neuronIterator = this.neurons.iterator();
        Iterator<Float> valueIterator = _values.iterator();
        while(neuronIterator.hasNext() && valueIterator.hasNext())
            neuronIterator.next().value = valueIterator.next();
    }
    public void evaluate(ArrayList<Float> _inputs){
        for(Neuron neuron : this.neurons)
            neuron.evaluate(_inputs);
    }
    public ArrayList<Float> getState(){
        ArrayList<Float> values = new ArrayList<>();
        for(Neuron neuron : this.neurons) values.add(neuron.value);
        return values;
    }
    public void populate(int _pop){
        for(Neuron neuron : this.neurons)
            neuron.populate(_pop);
    }

    public String toString(int _depth){
        String result = "\t".repeat(_depth) + "Layer(id=" + this.id + ", size=" + this.size + ")\n";
        int count = 0;
        for(Neuron neuron : this.neurons) {
            result += neuron.toString(_depth + 1);
            if(++count < this.neurons.size()) result += "\n";
        }
        return result;
    }
}
