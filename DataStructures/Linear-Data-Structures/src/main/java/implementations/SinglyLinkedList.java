package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, null);

        if(head == null){
            head = newNode;
            tail = newNode;
        }

        Node<E> currentHead = head;
        newNode.setNext(currentHead);
        head = newNode;

        size++;
    }

    @Override
    public void addLast(E element) {

        Node<E> newNode = new Node<>(element, null);

        if(head == null){
            head = newNode;
        }

        Node<E> currentLast = tail;
        if(currentLast != null){
            currentLast.setNext(newNode);
        }

        tail = newNode;
        size++;

    }

    @Override
    public E removeFirst() {

        Node<E> newHead = head.getNext();
        Node<E> currentHead = head;
        head = newHead;

        if(head == null){
            tail = null;
        }

        size--;
        return currentHead.getElement();
    }

    @Override
    public E removeLast() {

        if(head == null){
            return head.getElement();
        }

        Node<E> last = head;
        Node<E> previous = null;

        while(last.getNext() != null){
            previous = last;
            last.setNext(last.getNext());
        }

        previous.setNext(null);
        size--;

        return last.getElement();
    }

    @Override
    public E getFirst() {
        return this.head.getElement();
    }

    @Override
    public E getLast() {
        return this.tail.getElement();
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {

        return this.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
