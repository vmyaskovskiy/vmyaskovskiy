package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CheckTest тестирование задачи части 001 - урок Массив заполнен true или false. 6.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class CheckTest {
  @Test
  public void checkTrueTrue ()  {
      Check check = new Check();
      boolean[] table = new boolean[] {true, true, true};
      assertThat(check.mono(table), is(true));
  }
    @Test
    public void checkFalseTrue ()  {
        Check check = new Check();
        boolean[] table = new boolean[] {false, false, false};
        assertThat(check.mono(table), is(true));
    }
    @Test
    public void checkFalseFalse ()  {
        Check check = new Check();
        boolean[] table = new boolean[] {false, true, false};
        assertThat(check.mono(table), is(false));
    }
    @Test
    public void checkFalseFalseTrue ()  {
        Check check = new Check();
        boolean[] table = new boolean[] {false, false, true};
        assertThat(check.mono(table), is(false));
    }
}
