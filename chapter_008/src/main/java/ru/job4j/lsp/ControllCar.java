package ru.job4j.lsp;

public class ControllCar {
    private Parking parking;


    public  ControllCar(Parking parking) {
        this.parking = parking;
    }

    public boolean executrCar(Car car) {
        return parking.add(car);
    }
}
