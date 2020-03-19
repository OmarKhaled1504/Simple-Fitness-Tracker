package sources;

public class User {


    private static int calories = 0;
    private static double heartRate = 80;

    public static int getCalories() {
        return calories;
    }

    public static void setCalories(int calories) {
        User.calories += calories;
    }

    public static double getHeartRate() {
        return heartRate;
    }

    public static void setHeartRate(double heartRate) {
        User.heartRate = heartRate;
    }

}
