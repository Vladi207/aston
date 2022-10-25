package org.github.grashchenko.aston.myLinkedList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
        assertThat(myList.isEmpty(), equalTo(false));
        myList.clear();
        assertThat(myList.isEmpty(), equalTo(true));
    }

    @Test
    public void size() {
        assertThat(myList.size(), is(3));
    }

    @Test
    public void add() {
        myList.add(4);
        myList.add(5);
        assertThat(myList.get(3), is(4));
        assertThat(myList.get(4), is(5));
    }

    @Test
    public void addAll() {
        myList.addAll(list);
        myList.addAll(list);
        myList.addAll(list);
        myList.addAll(list);
        assertThat(myList.get(5), is(3));
        assertThat(myList.get(6), is(1));
    }

    @Test
    public void get() {
        assertThat(myList.get(1), is(2));
        assertThat(myList.get(2), is(3));
    }

    @Test
    public void set() {

        try {
            myList.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            myList.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {}

        Integer a = myList.set(1, 5);
        assertThat(a, is(2));
        a = myList.set(0, 6);
        assertThat(a, is(1));
        a = myList.set(2, 7);
        assertThat(a, is(3));

        assertThat(myList.get(0), is(6));
        assertThat(myList.get(1), is(5));
        assertThat(myList.get(2), is(7));
    }

    @Test
    public void remove() {
        Integer temp = myList.remove(0);
        assertThat(temp, is(1));
        assertThat(myList.size(), is(2));
        assertThat(myList.get(1), is(3));
    }

    @Test
    public void contains() {
        assertThat(myList.contains(2), equalTo(true));
        assertThat(myList.contains(5), equalTo(false));
        assertThat(myList.contains(null), equalTo(false));
    }

    @Test
    public void clear() {
        myList.clear();
        assertThat(myList.size(), is(0));
    }

    @Test
    public void toArray() {
        Object[] array = myList.toArray();
        assertThat(array[0], is(1));
        assertThat(array[1], is(2));
        assertThat(array[2], is(3));
    }

    @Test
    public void subList() {
        myList.addAll(list);
        List<Integer> sub = myList.subList(1, 4);
        assertThat(sub.get(1), is(3));
    }

    @Test
    public void testToString() {
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = myList.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), equalTo(false));
    }
}