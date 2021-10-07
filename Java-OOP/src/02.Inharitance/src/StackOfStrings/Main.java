package StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings myStack = new StackOfStrings();

        myStack.push("One");
        myStack.push("two");
        myStack.push("three");

        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());

    }
}
