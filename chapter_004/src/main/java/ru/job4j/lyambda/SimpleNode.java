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
        SimpleNode<E> z = x;
        SimpleNode<E> t = first;

        if (x.next != null) {
            while (y != null) {
                while (x != z) {
                    if (x != y) {
                        x = x.next;
                    } else {
                        return false;
                    }
                }
                if (x == y) {
                    return false;
                } else {
                    z = y;
                    y = y.next;
                    x = t;
                }
            }
        }
        return true;
    };
}
