package ru.job4j.lsp;
// класс для проверки количества мест на парковке
public class ParkingCar implements Parking {
    private int sumTrack; // количество мест грузовых машин
    private int sumPass; // количество мест легковых машин

    private boolean TrackToTrack = false; // метка что есть грузовые места для грузовых машин
    private boolean TrackToPass = false;  // метка что есть легковые места для грузовых машин
    private boolean PassToPass = false; // метка что есть легковые места для легковых машин

    public ParkingCar(int sumTrack, int sumPass) {
        this.sumTrack = sumTrack;
        this.sumPass = sumPass;
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
        int size = car.getsize();
        boolean res = true;
        // проверка , что машина Грузовая.
        // Если размер машины равен размеру грузовой - это грузовая машина
        if(size > 1) {
            // проверяем что остались грузовые места для грузовых машин
            if (sumTrack == 0) {
                // проверяем что остались пассажирские места для грузовых машин
                if (sumPass < size) {
                    res = false;
                } else {
                    // есть легковые места для грузовых машин
                    res = true;
                    this.TrackToPass = true;
                }
            } else {
                // есть грузовые места для грузовых машин
                this.TrackToTrack = true;
            }
            // проверяем есть ли легковые места для легковых машин
        } else if (sumPass == 0) {
            res = false;
        } else {
            // есть легковые места для легковых машин
            res = true;
            this.PassToPass = true;
        }
        return res;
    }

    @Override
    public boolean add(Car car) {
        boolean res = false;
        if(this.accept(car)) {
            if (this.PassToPass == true) {
                this.setSumPass();
                res = true;
            } else if (this.TrackToPass == true) {
                this.sumPass = this.sumPass - car.getsize();
                res = true;
            } else if (this.TrackToTrack == true) {
                this.setSumTrack();
                res = true;
            }
        }
        return res;
    }
}
