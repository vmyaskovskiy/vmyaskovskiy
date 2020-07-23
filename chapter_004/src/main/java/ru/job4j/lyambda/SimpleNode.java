package ru.job4j.lyambda;
/**
 * Class SimpleNode решение задачи 5.3.4. Задан связанный список. Определить цикличность.[#143707]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SimpleNode<E> {
    private E data;
    public SimpleNode<E> next;

    public SimpleNode(E data) {
        this.data = data;
    }

    public boolean hasCycle(SimpleNode first) {
        SimpleNode<E> x = first;
        SimpleNode<E> y = first.next;
         while (x != y) {
             if (y == null) {
             return true;
             }
             x = x.next;
             y = y.next.next;

         }
         return false;
    };
}
