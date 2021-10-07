package MathOperation;

public class MathOperation {

    protected MathOperation(){}

    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return add(a, b) + c;
    }

    public int add(int a, int b, int c, int d){
        return add(a, b) + add(c, d);
    }
}
