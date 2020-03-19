package sources.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sources.User;
import sources.activities.Activity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Summary {
    private static DecimalFormat df = new DecimalFormat("0.000");

    Activity swim;
    Activity run;
    Activity kBox;
    Activity sTrain;
    Stage stage;
    Scene scene;
    MainScene mainScene;
    public Summary(Stage stage) {
        this.stage = stage;
    }

    public void setActivities(Activity swim, Activity run, Activity kBox, Activity sTrain) {
        this.swim = swim;
        this.run = run;
        this.kBox = kBox;
        this.sTrain = sTrain;
    }

    public String summaryBuilder(Activity[] activities) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Summary: -\n\n");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("\t" + (i + 1) + ". " + activities[i].getActivityName() + ": -\n" + activities[i].printSummary()
                    + "\n\n");
        }
        return stringBuilder.toString();
    }

    public void prepareScene() {
        BackgroundImage myBI= new BackgroundImage(new Image("https://i.imgur.com/qVQDqdq.jpg",600,650,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        Activity[] activities = {swim, run, kBox, sTrain};

        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if (a1.getTotalCalories() != a2.getTotalCalories()) {
                    return a2.getTotalCalories() - a1.getTotalCalories();
                }
                return (a2.getTotalRate() > a1.getTotalRate()) ? 1 : -1;
            }
        });
        Label calsLabel = new Label("Results: -\n\tCalories Burnt: " + User.getCalories() + " Calories");
        calsLabel.setFont(new Font("Impact",20));
        calsLabel.setTextFill(Color.web("#FFFFFF"));
        df.setRoundingMode(RoundingMode.UP);
        Label rateLabel = new Label("\tHeart Rate: " + df.format(User.getHeartRate()) + " bpm");
        rateLabel.setFont(new Font("Impact",20));
        rateLabel.setTextFill(Color.web("#FFFFFF"));
        Label summary = new Label(summaryBuilder(activities));
        summary.setFont(new Font("Impact",20));
        summary.setTextFill(Color.web("#FFFFFF"));
        Button back = new Button("Back");
        back.setPrefSize(140, 40);
        back.setOnAction(e -> stage.setScene(mainScene.getScene()));
        HBox hBox = new HBox(back);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(calsLabel, rateLabel, summary, hBox);
        vBox.setBackground(new Background(myBI));
        scene = new Scene(vBox, 600, 650);
    }

    public Scene getScene() {
        return scene;
    }

    public void setMainScene(MainScene mainScene) {
        this.mainScene = mainScene;
    }
}
