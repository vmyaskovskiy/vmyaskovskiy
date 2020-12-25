package ru.job4j.lsp;

public class PassCar implements Car{
    private int sumTrack;
    private int sumPass;
    private int track;
    public PassCar(int sumTrack, int sumPass, int track) {
        this.sumTrack = sumTrack;
        this.sumPass = sumPass;
        this.track = track;
    }

    @Override
    public boolean accept() {
        //boolean res = true;
        //if(sumPass == 0) {
        //    res = false;
        //    }
        return (sumPass != 0);
    }

    @Override
    public void add() {

    }
}
