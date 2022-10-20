package org.github.grashchenko;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LinkedListSorterTest {

    private List<Integer> list;
    private LinkedListSorter<Integer> sorter;
    private Comparator<Integer> comparator;

    @Before
    public void setUp() throws Exception {

        comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer element1, Integer element2) {
                return element1.compareTo(element2);
            }
        };

        sorter = new LinkedListSorter<>();
    }

    @Test
    public void sort() {
        list = new MyLinkedList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        sorter.sort(list, comparator);
        isSorted(list);
    }

    private void isSorted(List<Integer> list) {
        assertThat(list.size(), is(5));
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));

    }
}