package org.github.grashchenko.myLinkedList;

import java.util.Comparator;
import java.util.List;

public class MergeSorter<T> {

    public void mergeSortInPlace(List<T> list, Comparator<T> comparator) {
        List<T> sorted = mergeSort(list, comparator);
        list.clear();
        list.addAll(sorted);
    }

    public List<T> mergeSort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }

        List<T> first = mergeSort(new MyLinkedList<>(list.subList(0, size/2)), comparator);
        List<T> second = mergeSort(new MyLinkedList<>(list.subList(size/2, size)), comparator);

        return merge(first, second, comparator);
    }

    private List<T> merge(List<T> first, List<T> second, Comparator<T> comparator) {
        List<T> result = new MyLinkedList<>();
        int total = first.size() + second.size();
        for (int i = 0; i<total; i++) {
            List<T> winner = compareElm(first, second, comparator);
            result.add(winner.remove(0));
        }
        return result;
    }

    private List<T> compareElm(List<T> first, List<T> second, Comparator<T> comparator) {
        if (first.size() == 0) {
            return second;
        }
        if (second.size() == 0) {
            return first;
        }
        int res = comparator.compare(first.get(0), second.get(0));
        if (res < 0) {
            return first;
        }
        if (res > 0) {
            return second;
        }
        return first;
    }
}
