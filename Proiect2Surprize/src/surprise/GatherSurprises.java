package surprise;

import java.util.ArrayList;
import java.util.Random;

public final class GatherSurprises {
    private static Random random = new Random();
    private GatherSurprises() {}

    public static ArrayList<ISurprise> gather(int n) {
        ArrayList<ISurprise> listaSurprize = new ArrayList<ISurprise>();
        for (int i = 0; i < n; i++) {
            listaSurprize.add(gather());
        }
        return listaSurprize;
    }

    public static ISurprise gather() {
        switch (random.nextInt(3)) {
            case 0:
                return FortuneCookie.generate();
            case 1:
                return Candies.generate();
            case 2:
                return MinionToy.generate();
            default:
                System.out.println("gather error");
                break;
        }
        return null;
    }
}
