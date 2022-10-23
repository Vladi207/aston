package org.github.grashchenko;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public MyLinkedList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T value) {
        if (isEmpty()) {
            this.head = new Node<>(value);
        } else {
            Node<T> temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(new Node<>(value));
        }
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        if(collection == null || collection.size() == 0){
            return false;
        }
        for (T element : collection) {
            add(element);
        }
        return true;
    }

    public T get(int index) {
        int currentIndex = 0;
        Node<T> temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException();
    }

    public T set(int index, T element) {
        int currentIndex = - 1;
        if (isEmpty()) {
            add(element);
            return null;
        }

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> temp = head;
        T elm = null;
        while (temp != null) {
            currentIndex++;
            if (currentIndex == index) {
                elm = temp.getValue();
                temp.setValue(element);
                return elm;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public T remove(int index) {
        if (index == 0) {
            T result = head.getValue();
            head = head.getNext();
            size--;
            return result;
        }

        int currentIndex = 0;
        Node<T> temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    public boolean contains(Object value) {
        if (isEmpty()) {
            return false;
        }

        Node<T> temp = head;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return true;
            } else {
                temp = temp.getNext();
            }
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public Object[] toArray() {
        if (isEmpty()) {
            return null;
        }

        int i = 0;
        Object[] result = new Object[size];
        Node<T> temp;
        for (temp = head; temp != null; temp = temp.getNext()) {
            result[i] = temp.getValue();
            i++;
        }
        return result;
    }

    public List<T> subList(int fromIndex, int toIndex) {

        if (fromIndex < 0)
            throw new IndexOutOfBoundsException();
        if (toIndex > size)
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        int i = 0;
        MyLinkedList<T> list = new MyLinkedList<T>();
        for (Node<T> temp = head; temp != null; temp = temp.getNext()) {
            if (i >= fromIndex && i < toIndex) {
                list.add(temp.getValue());
            }
            i++;
        }
        return list;
    }

    public String toString() {
        Object[] result = new Object[size];
        int index = 0;
        Node<T> temp = head;

        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    private class CustomIterator implements Iterator<T> {

        private int index = 0;


        @Override
        public boolean hasNext() {
            if (index < size()) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return get(index++);
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(size()-1);
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
