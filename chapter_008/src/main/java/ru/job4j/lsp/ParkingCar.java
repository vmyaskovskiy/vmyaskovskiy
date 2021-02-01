package ru.job4j.lsp;

public class ParkingCar implements Parking {
    private int sumTrack; // количество мест грузовых машин
    private int sumPass; // количество мест легковых машин
    private int track; // размер грузовой машины

    private boolean TrackToTrack = false; // метка что есть грузовые места для грузовых машин
    private boolean TrackToPass = false;  // метка что есть легковые места для грузовых машин
    private boolean PassToPass = false; // метка что есть легковые места для легковых машин

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
  // метод если грузовая машина встает на место для легковой
    public void setSumTrackToPass() {
        this.sumPass = this.sumPass - this.track;
    }

    public int getSumTrack() {
        return this.sumTrack;
    }
    public int getSumPass() {
        return this.sumPass;
    }

    @Override
    public boolean accept(Car car) {
        int sumTrack =  this.sumTrack;
        int sumPass = this.sumPass;
        int nTrack = this.track;
        boolean res = true;
        // проверка , что машина Грузовая.
        // Если размер машины равен размеру грузовой - это грузовая машина
        if(car.getsize() == nTrack) {
            // проверяем что остались грузовые места для грузовых машин
            if (sumTrack == 0) {
                // проверяем что остались пассажирские места для грузовых машин
                if (sumPass < nTrack) {
                    System.out.println("Мест нет");
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
                this.setSumTrackToPass();
                res = true;
            } else if (this.TrackToTrack == true) {
                this.setSumTrack();
                res = true;
            }
        }
        return res;
    }
}
