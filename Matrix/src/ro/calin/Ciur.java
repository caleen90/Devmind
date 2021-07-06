package ro.calin;

import java.util.ArrayList;

public class Ciur {
    public static void ciurE(ArrayList<Integer> arr) {
        while(arr.size() > 1) {
            System.out.println(arr.get(1));
            int x = arr.get(1);
            for (int i = 1; i < arr.size(); i++) {
                if(arr.get(i) % x == 0) {
                    arr.remove(i);
                }
            }
        }
    }
}
