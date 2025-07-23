package org.uade.structure.implementation.fixed;

import org.uade.exception.EmptyQueueException;
import org.uade.structure.definition.PriorityQueueADT;

public class StaticPriorityQueue implements PriorityQueueADT {

    private final String[] values = new String[100];
    private final int[] priorities = new int[100];
    private int size = 0;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola con prioridad se encuentra vacía");
        }
        return values[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola con prioridad se encuentra vacía");
        }
        return priorities[0];
    }

    @Override
    public void add(String value, int priority) {
        if (size == values.length) {
            throw new RuntimeException("La cola con prioridad está llena");
        }

        int i = size - 1;
        while (i >= 0 && priorities[i] > priority) {
            values[i + 1] = values[i];
            priorities[i + 1] = priorities[i];
            i--;
        }

        values[i + 1] = value;
        priorities[i + 1] = priority;
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola con prioridad se encuentra vacía");
        }
        for (int i = 1; i < size; i++) {
            values[i - 1] = values[i];
            priorities[i - 1] = priorities[i];
        }
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
