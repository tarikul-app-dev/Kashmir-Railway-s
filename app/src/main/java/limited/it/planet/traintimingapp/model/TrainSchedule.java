package limited.it.planet.traintimingapp.model;

/**
 * Created by Tarikul on 5/17/2018.
 */

public class TrainSchedule {
   public String train_number;
   public String day;

    public TrainSchedule(String train_number, String day, String timing) {
        this.train_number = train_number;
        this.day = day;
        this.timing = timing;
    }

  public   String timing;


    public String getTrainNumber() {
        return train_number;
    }

    public void setTrainNumber(String trainNumber) {
        this.train_number = trainNumber;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    public TrainSchedule(){

    }
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

  public   int serialNumber;
}
