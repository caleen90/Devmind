package surprise;

import java.util.ArrayList;

public class BagLIFO implements IBag{
    private ArrayList<ISurprise> bagOfSurprises = new ArrayList<ISurprise>();

    @Override
    public void put(ISurprise newSurprise) {
        this.bagOfSurprises.add(newSurprise);
    }

    @Override
    public ISurprise takeOut() {
        return this.bagOfSurprises.remove(bagOfSurprises.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.bagOfSurprises.isEmpty();
    }

    @Override
    public int size() {
        return this.bagOfSurprises.size();
    }

    @Override
    public void print() {
        for (int i = 0; i < bagOfSurprises.size(); i++) {
            this.bagOfSurprises.get(i).enjoy();
        }
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            this.bagOfSurprises.add(bagOfSurprises.takeOut());
        }
    }
}
