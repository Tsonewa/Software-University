package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> implements AbstractQueue<E> {

    LinkedList<E> queue = new LinkedList<>();

    @Override
    public void offer(E element) {
        this.queue.addLast(element);
    }

    @Override
    public E poll() {
        return this.queue.removeFirst();
    }

    @Override
    public E peek() {
        return this.queue.getFirst();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
