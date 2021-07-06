package surprise;

public class BagFactory implements IBagFactory {

    @Override
    public IBag makeBag(String type) {
        switch(type) {
            case "RANDOM":
                return new BagRandom();
            case "FIFO":
                return new BagFIFO();
            case "LIFO":
                return new BagLIFO();
            default:
                System.out.println("invalid input");
                return null;
        }
    }
}
