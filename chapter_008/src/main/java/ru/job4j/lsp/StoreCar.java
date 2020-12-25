package ru.job4j.lsp;

public class StoreCar {
    private int sumTrack;
    private int sumPass;
    private int track;

    public StoreCar(int sumTrack, int sumPass, int track) {
        this.sumTrack = sumTrack;
        this.sumPass = sumPass;
        this.track = track;
    }

    public int getSumTrack() {
        return this.sumTrack;
    }

    public int getSumPass() {
        return this.sumPass;
    }

    public int getTrack() {
        return this.track;
    }

    public void setSumTrack(int sumTrack) {
        this.sumTrack = sumTrack;
    }

    public void setSumPass(int sumPass) {
        this.sumPass = sumPass;
    }

}
