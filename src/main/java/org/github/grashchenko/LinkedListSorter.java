package org.github.grashchenko;

import java.util.Comparator;
import java.util.List;

public class LinkedListSorter<T> {

    public void sort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T element_i = list.get(i);
            int j = i;
            while (j > 0) {
                T element_j = list.get(j-1);
                if (comparator.compare(element_i, element_j) >= 0) {
                    break;
                }
                list.set(j, element_j);
                j--;
            }
            list.set(j, element_i);
        }
    }

}
