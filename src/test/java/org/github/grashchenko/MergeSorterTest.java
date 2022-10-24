package org.github.grashchenko;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MergeSorterTest {

    private MergeSorter<Integer> mergeSorter;
    private Comparator<Integer> comparator;
    private List<Integer> list;

    @Before
    public void setUp() throws Exception {
        comparator = Integer::compareTo;

        mergeSorter = new MergeSorter<>();
        list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(5);
    }

    @Test
    public void mergeSortInPlace() {
        mergeSorter.mergeSortInPlace(list, comparator);
        isSorted(list);
    }

    @Test
    public void mergeSort() {
        List<Integer> listSorted = mergeSorter.mergeSort(list, comparator);
        isSorted(listSorted);
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