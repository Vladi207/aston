package org.github.grashchenko;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class MyLinkedListTest {

    protected List<Integer> myList;
    protected List<Integer> list;

    @Before
    public void setUp() throws Exception {

        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyLinkedList<Integer>();
        myList.addAll(list);
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void size() {
    }

    @Test
    public void add() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void subList() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void iterator() {
    }
}