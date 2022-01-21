package implementations;

import interfaces.List;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
     Object[] array = new Object[1];
     int size = 0;

    @Override
    public boolean add(E element) {

        if(size == this.array.length){
            grow();
        }

        this.array[this.size++] = element;

        return true;
    }

    private void grow() {
        Object[] newArray = new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length ; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    @Override
    public boolean add(int index, E element) {

        validateIndex(index);
        if(size == this.array.length){
            grow();
        }
        E lastElement = this.get(this.size - 1);
        for (int i = this.size - 1; i > index ; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[this.size - 1] = lastElement;
        this.array[index] = element;
        this.size++;

        return true;
    }

    @Override
    public E get(int index) {

        validateIndex(index);
        return (E) this.array[index];
    }

    private void validateIndex(int index) {

        if(index < 0 || index > this.array.length){
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d"
                                                                            , index, this.size()));
        }
    }

    @Override
    public E set(int index, E element) {

        validateIndex(index);
       E oldElement = (E) this.array[index];
       this.array[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {

        validateIndex(index);
        E deletedElement = (E) this.array[index];
        this.array[index] = null;

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        size--;
        return deletedElement;
    }

    @Override
    public int size() {

        return this.array.length;
    }

    @Override
    public int indexOf(E element) {
        int index = -1;

        for (int i = 0; i < this.array.length ; i++) {
            if(this.array[i] == element){
                index = i;
            }
        }

        return index;
    }

    @Override
    public boolean contains(E element) {

        for (Object o : this.array) {
            return o == element;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int startIndex = 0;

            @Override
            public boolean hasNext() {
                return this.startIndex < size;
            }

            @Override
            public E next() {
                return get(startIndex++);
            }
        };
    }
}
