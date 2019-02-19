package ru.job4j.tracker.start;
/**
 * Class BaseAction абстрактный класс, частично реализует методы интерфейса UserAction..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public abstract class BaseActionTwo implements UserActionTwo {
    private final int key;
    private final String name;

    protected  BaseActionTwo(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return this.key;
    }
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
