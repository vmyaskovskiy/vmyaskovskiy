package ru.job4j.lyambda;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DinamicArrayList решение задачи 5.3.2. Создать контейнер на базе связанного списка [#143705]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
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
        E res =  this.first.data;
        this.first = oldLink;
        this.modCount++;
        return res;
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
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        private E data;
        private DinamicArrayList.Node<E> next;
        private Node(E data) {
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
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                tempLink = newLink;
                newLink = newLink.next;
                return tempLink.data;
            }
        };
        return iterator;
    }
}
