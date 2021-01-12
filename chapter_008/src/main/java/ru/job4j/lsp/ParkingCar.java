package ru.job4j.lsp;

public class ParkingCar implements Parking {
    private int sumTrack;
    private int sumPass;
    private int track;

    public ParkingCar(int sumTrack, int sumPass, int track) {
        this.sumTrack = sumTrack;
        this.sumPass = sumPass;
        this.track = track;
    }

    public void setSumTrack() {
        this.sumTrack--;
    }
    public void setSumPass() {
        this.sumPass--;
    }

    @Override
    public boolean accept(Car car) {
        int sumTrack =  this.sumTrack;
        int sumPass = this.sumPass;
        int nTrack = this.track;
        boolean res = true;
        if(car.getsize() == nTrack) {
            if (sumTrack == 0) {
                if (sumPass < nTrack) {
                    System.out.println("Мест нет");
                    res = false;
                } else {
                    res = true;
                    this.sumPass = (sumPass - nTrack);
                    System.out.println(" осталось легковых мест " + this.sumPass);
                    System.out.println(car.getsize() + " легковых места занято грузовой машиной");
                }
            } else {
                this.setSumTrack();
                System.out.println("осталось грузовых мест " + this.sumTrack);
            }
        } else if (sumPass == 0) {
            System.out.println("Мест нет");
            res = false;
        } else {
            res = true;
            this.setSumPass();
            System.out.println(" осталось легковых мест " + this.sumPass);
        }
        return res;
    }

    @Override
    public boolean add(Car car) {
        boolean res = true;
        if(!this.accept(car)) {
            res =  false;
        }
        return res;
    }
}
