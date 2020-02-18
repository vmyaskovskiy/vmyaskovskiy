package ru.job4j;

import ru.job4j.lyambda.Tree;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleTreeTest тестирование задачи  1. Создать элементарную структуру дерева[#143736]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SimpleTreeTest {
    Tree<Integer> tree = new Tree<>(1);

    @Test
    public void when6ElFindLastThen6() {
        tree.add(1, 2);
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(1, 3), is(false));
        assertThat(tree.add(4, 6), is(true));
        assertThat(tree.add(4, 6), is(false));
        assertThat(tree.findBy(1).get().getChildren().size(), is(3));
        assertThat(tree.findBy(4).get().getChildren().size(), is(1));
        assertThat(tree.add(6, 7), is(true));
        assertThat(tree.findBy(1).get().getChildren().size(), is(3));
        assertThat(tree.findBy(4).get().getChildren().size(), is(1));
        assertThat(tree.findBy(6).get().getChildren().size(), is(1));
        assertThat(tree.add(2, 7), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

}
