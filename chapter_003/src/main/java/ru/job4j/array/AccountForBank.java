package ru.job4j.array;

public class AccountForBank {
   private double value;
   private int requisites;

   public AccountForBank(double value, int requisites) {
       this.value = value;
       this.requisites = requisites;
   }
   public double getValue() {
       return this.value;
   }
   public void upValue(double value) {
       this.value = this.value + value;
   }
    public void downValue(double value) {
        this.value = this.value - value;
    }
   public int getRequisites() {
       return this.requisites;
   }
   public void  setValue(double value) {
       this.value = value;
   }
    @Override
    public String toString() {
        return "Account{"
                +
                "value='"
                + this.value
                + '\''
                +
                ", requisites='"
                + this.requisites
                +
                '}';
    }

}
