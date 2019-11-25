package ru.job4j.lyambda;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArrayList<E> implements Iterable<E> {
    private int size;
    private int l = 2;
    private int modCount = 0;
    private DinamicArrayList.Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        DinamicArrayList.Node<E> newLink = new DinamicArrayList.Node<>(data);
        if (size < l) {
        } else {
            l = l * 2;
        }
            newLink.next = this.first;
            this.first = newLink;
            this.size++;
            this.modCount++;
    }

    public int getModCount() {
        return this.modCount;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        DinamicArrayList.Node<E> oldLink = this.first.next;
        this.first = oldLink;
        this.size--;
        this.modCount++;
        return null;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        DinamicArrayList.Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E data;
        DinamicArrayList.Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        DinamicArrayList.Node<E> oldLink = this.first;
        int expectedModCount = this.modCount;
        int size = this.size;
        Iterator<E> iterator = new Iterator<E>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
                if (oldLink.next != null && ind < size) {
                    return true;
                }
                return false;
            }
            @Override
            public E next() {
                if (expectedModCount != getModCount()) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(ind++);
            }
        };
        return iterator;
    }
}
