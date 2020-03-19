package sources.activities;

import sources.User;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Activity {

    private static DecimalFormat df = new DecimalFormat("0.000");
    private int burntCalories;
    private double incRate;
    private int totalCalories;
    private double totalRate;
    private int timeSpent;
    private String activityName;

    public Activity(String activityName, int burntCalories, double incRate, int totalCalories, double totalRate, int timeSpent) {
        this.activityName = activityName;
        this.burntCalories = burntCalories;
        this.incRate = incRate;
        this.totalCalories = totalCalories;
        this.totalRate = totalRate;
        this.timeSpent = timeSpent;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent += timeSpent;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int time) {
        totalCalories += getCalories(time);
    }

    public double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(int time) {

        totalRate += User.getHeartRate() * incRate * time;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getCalories(int time) {
        return burntCalories * time;
    }

    public void doActivity(int time) {
        User.setCalories(burntCalories * time);
        User.setHeartRate(User.getHeartRate() + (User.getHeartRate() * incRate * time));
        setTotalCalories(time);
        setTotalRate(time);
        setTimeSpent(time);
    }


    public String printSummary() {
        df.setRoundingMode(RoundingMode.UP);
        String summary = "\t\tTotal Calories Burnt: " + this.totalCalories + " Calories\n\t\tTotal Heart Rate Increase: " + df.format(this.totalRate) + " bpm\n\t\t Time: "+getTimeSpent()+" minutes";
        return summary;
    }
}
