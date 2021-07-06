package RadixSort;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void print(LinkedList<String> x){
        for(String y:x){
            System.out.print(y + "   ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedList<String> test = new LinkedList<>();
        test.add("1000");
        test.add("4");
        test.add("25");
        test.add("319");
        test.add("88");
        test.add("51");
        test.add("3430");
        test.add("8471");
        test.add("701");
        test.add("1");
        test.add("2989");
        test.add("657");
        test.add("713");

        print(test);

        Radix obj1 = new Radix(test);
        obj1.sort();
        test = obj1.getCollection();
        print(test);

    }
}
