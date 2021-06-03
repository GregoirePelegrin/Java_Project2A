package GeneticAlgorithmLibrary;

import NeuralNetworkLibrary.Layer;
import NeuralNetworkLibrary.NeuralNetwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GeneticAlgorithm {
    public ArrayList<NeuralNetwork> nextGeneration;
    public ArrayList<NeuralNetwork> currentSorted;

    private int NBR_INDIVIDUALS;
    private int PB_CROSSOVER;
    private int PB_MUTATION;

    public GeneticAlgorithm(){
        this.nextGeneration = new ArrayList<>();
        this.currentSorted = new ArrayList<>();

        this.NBR_INDIVIDUALS = 100;
        this.PB_CROSSOVER = 10;
        this.PB_MUTATION = 10;
    }
    public GeneticAlgorithm(int _cf, int _ni, int _pc, int _pm){
        this.NBR_INDIVIDUALS = _ni;
        this.PB_CROSSOVER = _pc;
        this.PB_MUTATION = _pm;

        this.nextGeneration = new ArrayList<>();
        this.currentSorted = new ArrayList<>();
    }

    public ArrayList<Float> evolve(ArrayList<NeuralNetwork> _individuals){
        this.NBR_INDIVIDUALS = _individuals.size();
        this.currentSorted.clear();
        this.nextGeneration.clear();

        ArrayList<Float> scores = new ArrayList<>();
        for(NeuralNetwork nn : _individuals) scores.add(Float.valueOf(nn.fitness));

        this.sort(_individuals);
        this.variations();
        this.mutate(this.crossover(this.selection()));
        this.populate();

        return scores;
    }

    private ArrayList<NeuralNetwork> crossover(ArrayList<NeuralNetwork> _selected){
        ArrayList<NeuralNetwork> crossed = new ArrayList<>();

        Random random = new Random();
        if(_selected.size() % 2 != 0)
            crossed.add(new NeuralNetwork(_selected.remove(random.nextInt(_selected.size()))));
        while(_selected.size() > 0){
            int indPar1 = random.nextInt(_selected.size());
            int indPar2 = random.nextInt(_selected.size());
            while(indPar1 == indPar2) indPar2 = random.nextInt(_selected.size());
            NeuralNetwork par1 = _selected.remove((indPar1 < indPar2) ? indPar2 : indPar1);
            NeuralNetwork par2 = _selected.remove((indPar1 < indPar2) ? indPar1 : indPar2);
            if(random.nextInt(100) < this.PB_CROSSOVER){
                int indLay = random.nextInt(par1.layers.size());
                Layer temp = par1.layers.get(indLay);
                par1.layers.set(indLay, new Layer(par2.layers.get(indLay)));
                par2.layers.set(indLay, new Layer(temp));
            }
            crossed.add(par1);
            crossed.add(par2);
        }

        return crossed;
    }
    private void mutate(ArrayList<NeuralNetwork> crossed){
        Random random = new Random();
        for(NeuralNetwork nn : crossed){
            if(random.nextInt(100) < this.PB_MUTATION){
                int indexLay = random.nextInt(nn.layers.size()-1) + 1;
                int indexNeu = random.nextInt(nn.layers.get(indexLay).neurons.size());
                int indexWei = random.nextInt(nn.layers.get(indexLay).neurons.get(indexNeu).weights.size());
                nn.layers.get(indexLay).neurons.get(indexNeu).weights.set(indexWei, random.nextFloat() * 2 - 1);
            }
            this.nextGeneration.add(nn);
        }

    }
    private void populate(){
        for(int i=0; i<this.NBR_INDIVIDUALS-this.nextGeneration.size(); i++)
            this.nextGeneration.add(new NeuralNetwork());
    }
    private void sort(ArrayList<NeuralNetwork> _individuals){
        Collections.sort(_individuals, Collections.reverseOrder());
        for(NeuralNetwork nn : _individuals) this.currentSorted.add(new NeuralNetwork(nn));
    }
    private ArrayList<NeuralNetwork> selection(){
        ArrayList<NeuralNetwork> selected = new ArrayList<>();

        for(int i=0; i<this.NBR_INDIVIDUALS/2; i++) selected.add(new NeuralNetwork(this.currentSorted.get(i)));
        ArrayList<Integer> temp = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<this.NBR_INDIVIDUALS/10; i++){
            int r = random.nextInt(this.currentSorted.size()-this.NBR_INDIVIDUALS/2) + this.NBR_INDIVIDUALS/2;
            while(temp.contains(r)) r = random.nextInt(this.currentSorted.size()-this.NBR_INDIVIDUALS/2) + this.NBR_INDIVIDUALS/2;
            temp.add(r);
            selected.add(new NeuralNetwork(this.currentSorted.get(r)));
        }

        return selected;
    }
    private void variations(){
        this.nextGeneration.add(new NeuralNetwork(this.currentSorted.get(0)));

        Random random = new Random();
        for(int i=0; i<(float)15*this.NBR_INDIVIDUALS/40; i++){
            NeuralNetwork temp = new NeuralNetwork(this.currentSorted.get(0));
            for(int j=0; j<10; j++){
                int indexLay = random.nextInt(temp.layers.size()-1) + 1;
                int indexNeu = random.nextInt(temp.layers.get(indexLay).neurons.size());
                int indexWei = random.nextInt(temp.layers.get(indexLay).neurons.get(indexNeu).weights.size());
                temp.layers.get(indexLay).neurons.get(indexNeu).weights.set(indexWei,
                        (float) (temp.layers.get(indexLay).neurons.get(indexNeu).weights.get(indexWei) + (random.nextFloat()*0.3*2-0.3)));
                if(temp.layers.get(indexLay).neurons.get(indexNeu).weights.get(indexWei) > 1)
                    temp.layers.get(indexLay).neurons.get(indexNeu).weights.set(indexWei, Float.valueOf(1));
                else if(temp.layers.get(indexLay).neurons.get(indexNeu).weights.get(indexWei) < -1)
                    temp.layers.get(indexLay).neurons.get(indexNeu).weights.set(indexWei, Float.valueOf(-1));
            }
            this.nextGeneration.add(temp);
        }
    }
}
