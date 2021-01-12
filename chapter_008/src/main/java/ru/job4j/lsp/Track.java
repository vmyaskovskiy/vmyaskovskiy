package ru.job4j.lsp;

public class Track implements Car {
    private int size;
    public Track(int size) {
        this.size = size;
    }

    @Override
    public int getsize() {
        return this.size;
    }
}
