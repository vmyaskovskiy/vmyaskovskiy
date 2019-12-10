package ru.job4j.lyambda;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArrayList<E> implements Iterable<E> {
    private int modCount = 0;
    private DinamicArrayList.Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        DinamicArrayList.Node<E> newLink = new DinamicArrayList.Node<>(data);
            newLink.next = this.first;
            this.first = newLink;
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
        this.modCount++;
        return this.first.data;
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

    public E getFirst() {
        return this.first.data;
    }

    public DinamicArrayList.Node<E> getNode() {
        return this.first;
    }
    public void setNode(DinamicArrayList.Node<E> node) {
        this.first = node;
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
        DinamicArrayList.Node<E> link = this.first;
        int expectedModCount = this.modCount;
        Iterator<E> iterator = new Iterator<E>() {
            DinamicArrayList.Node<E> newLink = link;
            DinamicArrayList.Node<E> tempLink;
            @Override
            public boolean hasNext() {
                return newLink != null;
            }
            @Override
            public E next() {
                if (expectedModCount != getModCount()) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    tempLink = newLink;
                    newLink = newLink.next;
                    return tempLink.data;
                }
            }
        };
        return iterator;
    }
}
