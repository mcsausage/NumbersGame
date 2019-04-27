import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class Main extends Application {

    private TextField guess;
    private Text display;

    /*Create a number guessing game with a user interface.
- The user inputs their guess
- The application informs the user about,
wether their guess was too high or too low
- If the guess was correct, congratulate the user and close the app or start over */

    public static void main(String[] args) {
        launch(args);  //creates a stage for us, to do our stuff lol. Stages are widnows.
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 50, 50, 50));
        vBox.setSpacing(10);

        primaryStage.setTitle("NUMBERS GUESSING GAME");

        System.out.println("Please guess a number from 1 - 100");
        guess = new TextField();
        display = new Text();

        Button guessButton = new Button("Check number");

        vBox.getChildren().addAll(guess, guessButton, display);

        guessButton.setOnAction(event -> {
            guessSelect();
        });

        Scene scene = new Scene(vBox, 480, 640);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void guessSelect() {
        Random rand = new Random();
        int random = rand.nextInt(100);

        String userGuess = guess.getText();
        int userNumber = Integer.parseInt(userGuess);

            if (userNumber == random) {
                display.setText("You guessed right!");
            } else if (userNumber > random) {
                display.setText("Too High");
            } else if (userNumber < random) {
                display.setText("Too low");
        }

    }

}
