package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<E> implements AbstractStack<E> {

    LinkedList<E> stack = new LinkedList<>();

    @Override
    public void push(E element) {
        this.stack.add(element);
    }

    @Override
    public E pop() {
        return this.stack.removeLast();
    }

    @Override
    public E peek() {
        return this.stack.getLast();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
     return null;
    }
}
