package ru.job4j.lsp;

public class TestCar {


    public static void main(String[] args) {
        StoreCar storeCar = new StoreCar(1, 2, 2);
        Track track = new Track(storeCar);
      //  PassCar passCar = new PassCar(storeCar.getSumTrack(), storeCar.getSumPass(), storeCar.getTrack());
        ControllCar controllCar = new ControllCar(track);
       // ControllCar controllCar1 = new ControllCar(passCar);
       // ControllCar controllCar2 = new ControllCar(track);
        System.out.println(controllCar.executrCar());
        System.out.println(storeCar.getSumTrack() + " " + storeCar.getSumPass());
        System.out.println(storeCar.getSumTrack() + " " + storeCar.getSumPass());
       // System.out.println(controllCar1.executrCar());
       // System.out.println(controllCar2.executrCar());

    }




}
