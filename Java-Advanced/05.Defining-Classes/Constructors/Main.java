package Generics;

public class Main {

    public static void main(String[] args) {

        Jar<String> jarString = new Jar<>();

        jarString.add("Hello");

        System.out.println(jarString.remove());
    }
}
