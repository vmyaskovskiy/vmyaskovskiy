package ru.job4j.lyambda;
import java.util.*;
/**
 * Class Tree решение задачи  1. Создать элементарную структуру дерева[#143736]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E parent) {
        this.root = new Node<>(parent);
    }
    @Override
    public boolean add(E parent, E child) {

        Optional<Node<E>> nodeParent = findBy(parent);
        Node<E> childOne = new Node<>(child);
        List<Node<E>> children;
       if (findBy(child).isPresent()) {
           return false;
       }
         if (nodeParent.isEmpty()) {
            Node<E> parentOne = new Node<>(parent);
            children =  this.root.getChildren();
            children.add(parentOne);
            parentOne.getChildren().add(childOne);
            return true;
        } else  {
            children =  nodeParent.get().getChildren();
                children.add(childOne);
                 return true;
        }
    }

    public boolean isBinary() {
        boolean res = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (!el.children.isEmpty()) {
                if (el.children.size() > 2) {
                    res = false;
                }
                data.addAll(el.children);
            }
        }
        return res;
    }


    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}

