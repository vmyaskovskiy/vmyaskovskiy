package ru.job4j;
import org.junit.Test;
import ru.job4j.lyambda.SimpleNode;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class SimpleNodeTest {


    @Test
    public void whenLastElementsGoToNull() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        assertThat(node1.hasCycle(node1), is(true));
    }

    @Test
    public void whenLastElementsGoToNode1() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        assertThat(node1.hasCycle(node1), is(false));
    }
    @Test
    public void whenLastElementsGoToNode2() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        assertThat(node1.hasCycle(node1), is(false));
    }
    @Test
    public void whenNode3ElementsGoToNode2() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        node4.next = node5;
        node5.next = null;
        assertThat(node1.hasCycle(node1), is(false));
    }
    @Test
    public void whenNode4ElementsGoToNode2() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        node5.next = null;
        assertThat(node1.hasCycle(node1), is(false));
    }
    @Test
    public void whenNode1ElementsGoToNode1() {
        SimpleNode<Integer> node1 = new SimpleNode<>(1);
        SimpleNode<Integer> node2 = new SimpleNode<>(2);
        SimpleNode<Integer> node3 = new SimpleNode<>(3);
        SimpleNode<Integer> node4 = new SimpleNode<>(4);
        SimpleNode<Integer> node5 = new SimpleNode<>(5);
        node1.next = node1;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        assertThat(node1.hasCycle(node1), is(false));
    }

}
