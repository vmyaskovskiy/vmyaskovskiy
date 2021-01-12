package ru.job4j.lsp;

public class TestCar {


    public static void main(String[] args) {
        Track track = new Track(2);
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(2,6,2));
        controllCar.executrCar(track);
        controllCar.executrCar(passCar);
        controllCar.executrCar(track);
        controllCar.executrCar(track);
        controllCar.executrCar(passCar);
        controllCar.executrCar(track);
        controllCar.executrCar(track); // выводит , мест нет

    }




}
