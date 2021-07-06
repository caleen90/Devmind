package RadixSort;

import java.util.*;

public class Radix {
    private LinkedList<String> collection;
    private Deque<String> q0;
    private Deque<String> q1;
    private Deque<String> q2;
    private Deque<String> q3;
    private Deque<String> q4;
    private Deque<String> q5;
    private Deque<String> q6;
    private Deque<String> q7;
    private Deque<String> q8;
    private Deque<String> q9;
    private int maxSize;

    public Radix(LinkedList<String> collection) {
        this.collection = collection;
        q0 = new LinkedList<>();
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        q3 = new LinkedList<>();
        q4 = new LinkedList<>();
        q5 = new LinkedList<>();
        q6 = new LinkedList<>();
        q7 = new LinkedList<>();
        q8 = new LinkedList<>();
        q9 = new LinkedList<>();
        maxSize = 0;
    }

    public void calculateMaxSize(){
        for(String x: this.collection){
            int cnt = 0;
            int i = Integer.valueOf(x);
            while(i != 0) {
                i /= 10;
                cnt++;
            }
            if(cnt > this.maxSize){
                this.maxSize = cnt;
            }
        }
    }

    public void align(){
        ListIterator<String> i = this.collection.listIterator();
        while(i.hasNext()){
            String result = i.next();
            int x = this.maxSize - result.length();
            for(int j = 0; j < x; j++){
                result = "0" + result;
            }
            i.set(result);
        }
    }

    public void removeZero(){
        ListIterator<String> i = this.collection.listIterator();
        while(i.hasNext()){
            String result = i.next();
            int cnt = 0;
            while(cnt < this.maxSize - 1 && result.charAt(cnt) == '0'){
                result = result.substring(1);
            }
            i.set(result);
        }
    }

    public LinkedList<String> getCollection(){
        return this.collection;
    }

    public void  sort(){
        this.calculateMaxSize();
        this.align();
        for(int i = 0; i < this.maxSize; i++){
            while(!collection.isEmpty()){
                int y = Character.getNumericValue(collection.peek().charAt(this.maxSize - i - 1));
                switch (y){
                    case 0:
                        q0.add(collection.remove());
                        break;
                    case 1:
                        q1.add(collection.remove());
                        break;
                    case 2:
                        q2.add(collection.remove());
                        break;
                    case 3:
                        q3.add(collection.remove());
                        break;
                    case 4:
                        q4.add(collection.remove());
                        break;
                    case 5:
                        q5.add(collection.remove());
                        break;
                    case 6:
                        q6.add(collection.remove());
                        break;
                    case 7:
                        q7.add(collection.remove());
                        break;
                    case 8:
                        q8.add(collection.remove());
                        break;
                    case 9:
                        q9.add(collection.remove());
                        break;
                    default:
                        System.out.println("error?");
                }
            }
            this.addToCollectionAndClear();
        }
        this.removeZero();
    }

    public void addToCollectionAndClear(){
        collection.addAll(q0);
        collection.addAll(q1);
        collection.addAll(q2);
        collection.addAll(q3);
        collection.addAll(q4);
        collection.addAll(q5);
        collection.addAll(q6);
        collection.addAll(q7);
        collection.addAll(q8);
        collection.addAll(q9);
        q0.clear();
        q1.clear();
        q2.clear();
        q3.clear();
        q4.clear();
        q5.clear();
        q6.clear();
        q7.clear();
        q8.clear();
        q9.clear();
    }
}
