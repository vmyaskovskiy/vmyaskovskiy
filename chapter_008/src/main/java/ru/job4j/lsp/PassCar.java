package ru.job4j.lsp;

public class PassCar implements Car{

    private int size;
    public  PassCar(int size) {
        this.size = size;
    }

    @Override
    public int getsize() {
        return this.size;
    }
}
