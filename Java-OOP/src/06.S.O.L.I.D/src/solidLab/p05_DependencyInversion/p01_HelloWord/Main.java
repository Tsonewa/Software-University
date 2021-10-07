package solidLab.p05_DependencyInversion.p01_HelloWord;

public class Main {
    public static void main(String[] args)

    {
        HelloWorld person = new HelloWorld();

        System.out.println(person.greeting("Pesho"));
    }
}
