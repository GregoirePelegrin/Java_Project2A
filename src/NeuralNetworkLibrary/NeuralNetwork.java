package NeuralNetworkLibrary;

import java.util.ArrayList;

public class NeuralNetwork implements Comparable<NeuralNetwork>{
    private static int count = 0;

    public int id;
    public float fitness;
    public ArrayList<Layer> layers;

    public NeuralNetwork(){
        this.id = NeuralNetwork.count++;

        this.fitness = -10;
        this.layers = new ArrayList<>();
        this.populate();
    }
    public NeuralNetwork(NeuralNetwork _network){
        this.id = NeuralNetwork.count++;

        this.fitness = _network.fitness;
        this.layers = new ArrayList<>();
        for(Layer layer : _network.layers) this.layers.add(new Layer(layer));
    }

    public void assignInput(ArrayList<Double> _inputs){
        for(Layer layer : this.layers)
            layer.assign(_inputs);
    }
    public ArrayList<Double> evaluate(ArrayList<Double> _inputs){
        this.assignInput(_inputs);
        for(int i=0; i<this.layers.size()-1; i++) this.layers.get(i+1).evaluate(this.layers.get(i).getState());
        return this.layers.get(this.layers.size()-1).getState();
    }
    public void populate(){
        this.layers.clear();
        this.layers.add(new Layer(0, Util.dimensions.get(0)));
        for(int i=0; i<Util.dimensions.size()-1; i++) this.layers.add(new Layer(Util.dimensions.get(i), Util.dimensions.get(i+1)));
    }

    public String toString(int _depth){
        String result = "\t".repeat(_depth) + "NeuralNetwork(id=" + this.id + ", fitness=" + this.fitness + ")\n";
        int count = 0;
        for(Layer layer : this.layers) {
            result += layer.toString(_depth + 1);
            if(++count < this.layers.size()) result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(NeuralNetwork o) {
        if(this.fitness - o.fitness < 0) return -1;
        if(this.fitness == o.fitness) return 0;
        return 1;
    }
}
