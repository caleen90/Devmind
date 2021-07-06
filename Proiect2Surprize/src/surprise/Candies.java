package surprise;

public class Candies implements ISurprise{
    private int number;
    private String type;

    private static String[] types = {"chocolate","vanilla","fruits","jelly"};

    private Candies(int number,String type) {
        this.number = number;
        this.type = type;
    }

    public static Candies generate() {
        Candies candie = new Candies(random.nextInt(10) + 1,types[random.nextInt(types.length)]);
        return candie;
    }

    @Override
    public void enjoy() {
        System.out.println("Felicitari! Ai primit " + this.number + " bomboane cu " + this.type);
    }

}
