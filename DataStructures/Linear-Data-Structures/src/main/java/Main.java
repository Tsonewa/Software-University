import implementations.ArrayList;
import implementations.Queue;
import implementations.SinglyLinkedList;
import implementations.Stack;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("gosho");
        list.addFirst("pesho");

        for (int i = list.size(); i >  0; i--) {
            System.out.println(list.getLast());
            list.removeLast();
        }
    }
}
