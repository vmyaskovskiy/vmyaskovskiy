package ru.job4j.traсker.models;
import java.util.Objects;
import java.util.Date;
/**
 * Class Item решение задачи части 002 - урок Инкапсуляция.Реализовать класс Tracker 2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private  String id;
    private String name;
    private String description;
    private Date create;

    public Item() {
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        Date date = new Date();
        this.create = date;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public  Date getCreate() {
        return this.create;
    }
    public void setCreate(Date create) {
        this.create = create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name)
                &&
                Objects.equals(description, item.description);
    }
    @Override
    public int hashCode() {

        return Objects.hash(name, description);
    }
    @Override
    public String toString() {
        return "Item{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", create=" + this.create +
                '}';
    }
}
