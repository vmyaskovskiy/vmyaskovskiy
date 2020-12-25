package ru.job4j.lsp;

public class ControllCar {
    private Car car;
   // private StoreCar storeCar;
   // private int sumTrack;
   // private int sumPass;
   // private int track;

    public  ControllCar(Car car) {
        this.car = car;
      //  this.storeCar = storeCar;
    }

    public boolean executrCar() {
      //  this.sumPass = storeCar.getSumPass();
      //  this.sumTrack = storeCar.getSumTrack();
      //  this.track = storeCar.getTrack();
        return car.accept();
    }
}
