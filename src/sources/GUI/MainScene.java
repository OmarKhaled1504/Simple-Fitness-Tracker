package sources.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sources.User;
import sources.activities.Activity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainScene {

    private static DecimalFormat df = new DecimalFormat("0.000");

    Activity swim;
    Activity run;
    Activity kBox;
    Activity sTrain;
    Summary summary;
    Stage stage;
    Scene scene;
    int time;

    public MainScene(Stage stage) {
        this.stage = stage;
    }

    public void setActivities(Activity swim, Activity run, Activity kBox, Activity sTrain) {
        this.swim = swim;
        this.run = run;
        this.kBox = kBox;
        this.sTrain = sTrain;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void prepareScene() {

        GridPane pane = new GridPane();

        pane.setHgap(10);
        pane.setVgap(10);

        Button swimB = new Button();
        swimB.setText("Swim");
        swimB.setPrefWidth(140);
        Button kBoxB = new Button();
        kBoxB.setText("Kick Box");
        kBoxB.setPrefWidth(140);
        Button sTrainB = new Button();
        sTrainB.setText("Strength Train");
        sTrainB.setPrefWidth(140);
        Button runB = new Button();
        runB.setText("Run");
        runB.setPrefWidth(140);
        Button summaryBtn = new Button();
        summaryBtn.setText("Summary");
        summaryBtn.setPrefSize(140, 40);
        Button exit = new Button();
        exit.setText("Exit");
        exit.setPrefSize(140, 40);

        TextField timeField = new TextField();
        timeField.setPrefSize(50, 5);

        Label timeLabel = new Label("Time:");
        Label mins = new Label("(in minutes)");
        Label calsLabel = new Label("Calories Burnt: " + User.getCalories() + " Calories");
        Label rateLabel = new Label("Heart Rate: " + User.getHeartRate() + " bpm");
        Label message = new Label("");

        HBox btns = new HBox(swimB, kBoxB, sTrainB, runB);
        btns.setSpacing(10);
        HBox timeLF = new HBox(timeLabel, timeField, mins, message);
        timeLF.setSpacing(5);
        VBox userInfo = new VBox(calsLabel, rateLabel);
        userInfo.setSpacing(2);
        HBox userSummary = new HBox(userInfo, summaryBtn, exit);
        userSummary.setSpacing(10);


        kBoxB.setOnAction(e -> {
            String timeStr = timeField.getText();
            if (timeStr.isEmpty()) {
                message.setTextFill(Color.web("#FF0000"));
                message.setText("Field cannot be empty, Enter time in minutes.");
            } else {
                if (timeStr.matches("[0-9]+")) {
                    message.setTextFill(Color.web("#00FF00"));
                    message.setText(kBox.getActivityName() + " recorded successfully!");
                    time = Integer.parseInt(timeStr);
                    kBox.doActivity(time);
                    calsLabel.setText("Calories Burnt: " + User.getCalories() + " Calories");
                    df.setRoundingMode(RoundingMode.UP);
                    rateLabel.setText("Heart Rate: " + df.format(User.getHeartRate()) + " bpm");
                } else {
                    message.setTextFill(Color.web("#FF0000"));
                    message.setText("Field cannot contain characters, Use numbers only.");
                }
            }
        });
        sTrainB.setOnAction(e -> {
            String timeStr = timeField.getText();
            if (timeStr.isEmpty()) {
                message.setTextFill(Color.web("#FF0000"));
                message.setText("Field cannot be empty, Enter time in minutes.");
            } else {
                if (timeStr.matches("[0-9]+")) {
                    message.setTextFill(Color.web("#00FF00"));
                    message.setText(sTrain.getActivityName() + " recorded successfully!");
                    time = Integer.parseInt(timeStr);
                    sTrain.doActivity(time);
                    calsLabel.setText("Calories Burnt: " + User.getCalories() + " Calories");
                    df.setRoundingMode(RoundingMode.UP);
                    rateLabel.setText("Heart Rate: " + df.format(User.getHeartRate()) + " bpm");
                } else {
                    message.setTextFill(Color.web("#FF0000"));
                    message.setText("Field cannot contain characters, Use numbers only.");
                }
            }
        });
        runB.setOnAction(e -> {
            String timeStr = timeField.getText();
            if (timeStr.isEmpty()) {
                message.setTextFill(Color.web("#FF0000"));
                message.setText("Field cannot be empty, Enter time in minutes.");
            } else {
                if (timeStr.matches("[0-9]+")) {
                    message.setTextFill(Color.web("#00FF00"));
                    message.setText(run.getActivityName() + " recorded successfully!");
                    time = Integer.parseInt(timeStr);
                    run.doActivity(time);
                    calsLabel.setText("Calories Burnt: " + User.getCalories() + " Calories");
                    df.setRoundingMode(RoundingMode.UP);
                    rateLabel.setText("Heart Rate: " + df.format(User.getHeartRate()) + " bpm");

                } else {
                    message.setTextFill(Color.web("#FF0000"));
                    message.setText("Field cannot contain characters, Use numbers only.");
                }
            }
        });
        swimB.setOnAction(e -> {

            String timeStr = timeField.getText();
            if (timeStr.isEmpty()) {
                message.setTextFill(Color.web("#FF0000"));
                message.setText("Field cannot be empty, Enter time in minutes.");
            } else {
                if (timeStr.matches("[0-9]+")) {
                    message.setTextFill(Color.web("#00FF00"));
                    message.setText(swim.getActivityName() + " recorded successfully!");
                    time = Integer.parseInt(timeStr);
                    swim.doActivity(time);
                    calsLabel.setText("Calories Burnt: " + User.getCalories() + " Calories");
                    df.setRoundingMode(RoundingMode.UP);
                    rateLabel.setText("Heart Rate: " + df.format(User.getHeartRate()) + " bpm");

                } else {
                    message.setTextFill(Color.web("#FF0000"));
                    message.setText("Field cannot contain characters, Use numbers only.");
                }
            }
        });

        exit.setOnAction(e -> System.exit(42069));

        summaryBtn.setOnAction(e -> {
            summary.prepareScene();
            stage.setScene(summary.getScene());
        });

        scene = new Scene(pane, 600, 125);
        pane.add(btns, 0, 0);
        pane.add(timeLF, 0, 1);
        pane.add(userSummary, 0, 2);

    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
