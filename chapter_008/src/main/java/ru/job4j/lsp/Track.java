package ru.job4j.lsp;

public class Track implements Car {
   // private int sumTrack;
   // private int sumPass;
   // private int track;
    private StoreCar storeCar;

   // public Track(int sumTrack, int sumPass, int track) {
   //     this.sumTrack = sumTrack;
   ////     this.sumPass = sumPass;
   //     this.track = track;
   // }

    public Track(StoreCar storeCar) {
        this.storeCar = storeCar;
    }

    @Override
    public boolean accept() {
        int track = storeCar.getSumTrack();
        int pass = storeCar.getSumPass();
        int nTrack = storeCar.getTrack();
        boolean res = true;
        if(track == 0) {
            if(pass < nTrack) {
                res = false;
            } else {
                res = true;
                storeCar.setSumPass(pass - nTrack);
                System.out.println(" pass " + pass);
            }
        }
        storeCar.setSumTrack(track--);
        System.out.println(" track " + track);
        return res;
    }

    @Override
    public void add() {

    }
}
