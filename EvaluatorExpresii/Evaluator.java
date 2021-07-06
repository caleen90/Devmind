package EvaluatorExpresii;

import java.util.Deque;
import java.util.LinkedList;

public class Evaluator {
    private String normal;
    private String postFix;
    private Deque<Integer> result;
    private StringBuilder temp;
    private Deque<Character> op;
    private int rezultat;

    public Evaluator(String normal) {
        this.normal = normal;
        this.temp = new StringBuilder(normal.length());
        this.op = new LinkedList<>();
        this.result = new LinkedList<>();
        this.rezultat = 0;
    }

    public void conversie() {
        for (int i = 0; i < this.normal.length(); i++){
            Character x = normal.charAt(i);
            if(this.isNumber(x)){
                temp.append(x);
            }else if(this.isOperator(x)){
                while(!op.isEmpty() && op.peek() != '(' && (this.precedenta(x) < this.precedenta(op.peek())
                        || this.precedenta(x) == this.precedenta(op.peek()) && this.stangaDreapta(op.peek()))){
                    temp.append(op.pop());
                }
                op.push(x);
            } else if(x == '(') {
                op.push(x);
            } else if(x == ')') {
                while(!op.isEmpty() && op.peek() != '('){
                    temp.append(op.pop());
                }
                if(op.isEmpty()) {
                    System.out.println("error paranteze ordine gresita");
                }
                if(!op.isEmpty() && op.peek() == '(') {
                    op.pop();
                }
            }
        }
        while(!op.isEmpty()){
            if(op.peek() == '(') {
                System.out.println("error paranteze ordine gresita");
            }
            temp.append(op.pop());
        }
        this.postFix = temp.toString();
    }

    public int precedenta(Character x){
        if(x == '+' || x == '-'){
            return 11;
        }
        if(x == '*' || x == '/'){
            return 12;
        }
        if(x == '^'){
            return 13;
        }
        return 0;
    }

    public boolean stangaDreapta(Character x){
        if(x == '^'){
            return false;
        }
        return true;
    }

    public boolean isNumber(Character x){
        switch(x){
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                return true;
            default:
                return false;
        }
    }

    public boolean isOperator(Character x){
        switch(x){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }

    public void printPostFix(){
        System.out.println(this.postFix);
    }

    public int eval(){
        for(int i = 0; i < postFix.length(); i++) {
            Character x = postFix.charAt(i);
            if(this.isNumber(x)){
                this.result.push(Character.getNumericValue(x));
            } else if(this.isOperator(x)){
                if(result.size() < 2){
                    System.out.println("expresie postfixata gresita. nu sunt destui operanzi");
                }
                int op1 = result.pop();
                int op2 = result.pop();
                this.rezultat = this.calcul(op1,op2,x);
                this.result.push(this.rezultat);
            }
        }
        if(result.size() > 1){
            System.out.println("MISTAKE");
        }
        return rezultat;
    }

    public int calcul(int op1,int op2, Character x){
        if(x == '+'){
            return op2 + op1;
        }
        if(x == '-'){
            return op2 - op1;
        }
        if(x == '*'){
            return op2 * op1;
        }
        if(x == '/'){
            return op2 / op1;
        }
        if(x == '^'){
            int y = 1;
            for (int i = 0;i < op1;i++){
                y *= op2;
            }
            return y;
        }
        System.out.println("problema la calcul");
        return -1;
    }

}
