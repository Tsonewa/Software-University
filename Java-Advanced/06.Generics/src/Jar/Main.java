package Jar;

public class Main {
    public static void main(String[] args) {

Jar<Integer> jarOne = new Jar<Integer>();
Jar<String> jarTwo = new Jar<String>();

jarOne.add(12);
jarTwo.add("Pesho");
        System.out.println(jarOne.remove());
        System.out.println(jarTwo.remove());
    }
}
