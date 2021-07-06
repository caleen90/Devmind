package surprise;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    private IBag tolba;
    private int waitTime;

    public AbstractGiveSurprises(String bagType,int waitTime) {
        this.tolba = new BagFactory().makeBag(bagType);
        this.waitTime = waitTime;
    }

    public void put(ISurprise newSurprise){
        this.tolba.put(newSurprise);
    }


    public void put(IBag bagOfSurprises) {
        this.tolba.put(bagOfSurprises);
    }

    public void give() {
        this.tolba.takeOut().enjoy();
        this.giveWithPassion();
    }

    public void giveAll() {
        while(!this.isEmpty()) {
            this.give();

            try {
                TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void printAll() {
            this.tolba.print();
    }
    public IBag moveBag() {
        return this.tolba;
    }

    public boolean isEmpty() {
       return this.tolba.isEmpty();
    }

    abstract void giveWithPassion();
}
