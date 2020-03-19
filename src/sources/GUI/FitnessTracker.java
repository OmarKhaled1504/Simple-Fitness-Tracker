package sources.GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import sources.activities.*;

public class FitnessTracker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Activity swim = new Swimming("Swimming", 4, 0.002, 0, 0, 0);
        Activity run = new Running("Running", 5, 0.003, 0, 0, 0);
        Activity kBox = new KickBoxing("Kick Boxing", 3, 0.005, 0, 0, 0);
        Activity sTrain = new StrengthTraining("Strength Training", 5, 0.006, 0, 0, 0);

        primaryStage.setTitle("Fitness Tracker");
        MainScene mainScene = new MainScene(primaryStage);
        Summary summary = new Summary(primaryStage);
        mainScene.setActivities(swim, run, kBox, sTrain);
        summary.setActivities(swim, run, kBox, sTrain);
        mainScene.prepareScene();
        mainScene.setSummary(summary);
        summary.setMainScene(mainScene);
        primaryStage.setScene(mainScene.getScene());
        primaryStage.show();
    }


}
