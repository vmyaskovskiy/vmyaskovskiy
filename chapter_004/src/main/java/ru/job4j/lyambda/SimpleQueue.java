package ru.job4j.lyambda;
/**
 * Class SimpleQueue решение задачи 5.3.3.1 Очередь на двух стеках[#143706]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> stackTwo = new SimpleStack<>();
    private int index = 0;

    private void setIndex(int i) {
        this.index = i;
    }

    public T poll() {
        int i = index;
        while (index > 0) {
            stackTwo.push(stack.poll());
            setIndex(--index);
        }
        T res = stackTwo.poll();
        setIndex(--i);
        while (index  > 0) {
           stack.push(stackTwo.poll());
            setIndex(--index);
        }
        setIndex(i);
       return res;
    }
    public void push(T value) {
        stack.push(value);
        setIndex(++index);
    };
}
