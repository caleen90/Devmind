package EvaluatorExpresii;

public class Main {
    public static void main(String[] args) {
        Evaluator obj1 = new Evaluator("3+(2+1)*2^3^2-8/(5-1*2/2)");
        System.out.println("3+(2+1)*2^3^2-8/(5-1*2/2)");
        obj1.conversie();
        obj1.printPostFix();
        System.out.println(obj1.eval());
    }
}
