package ru.job4j.Lsp;

public interface Menu {
    public void add(String parentName, Item child);
    public Item get(String name);
}
