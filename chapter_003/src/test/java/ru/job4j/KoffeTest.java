package ru.job4j;

import org.junit.Test;
import ru.job4j.array.Koffe;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class KoffeTest тестирование задачи Кофемашина. [#34741]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class KoffeTest {
  @Test
  public void oneTest() {
      Koffe koffe = new Koffe();
      List<Integer> res = new ArrayList<>();
      res.add(10);
      res.add(5);
      List<Integer> out = koffe.changes(50, 35);
      assertThat(out.size(), is(2));
      assertThat(res, is(out));
    }
    @Test
    public void twoTest() {
        Koffe koffe = new Koffe();
        List<Integer> res = new ArrayList<>();
        res.add(10);
        res.add(2);
        res.add(1);
        List<Integer> out = koffe.changes(50, 37);
        assertThat(out.size(), is(3));
        assertThat(res, is(out));
    }



}
