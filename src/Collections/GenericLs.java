package Collections;

import java.util.Iterator;

public class GenericLs<T> implements Iterable<T> {
    private T[] items = (T[]) new Object[10];
    private int count = 0;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }


    //implement iterator class
    private class ListIterator implements Iterator<T>{
        private final GenericLs<T> list;
        private int index;

        public ListIterator(GenericLs<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.count;
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
