package p1caccia.test;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import javax.script.ScriptEngine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SampleGUI extends Application {

	int currPos[] = { 3, 3 };

	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) {
		final int size = 7;
		javafx.scene.control.Button b[][] = new javafx.scene.control.Button[7][7];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				b[row][col] = new javafx.scene.control.Button();
				b[row][col].setStyle("-fx-background-color: white;");
			}
		}
		GridPane root = new GridPane();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (row == col && row == 3) {
					b[row][col].setStyle("-fx-background-color: black;");
				}
				root.add(b[row][col], col, row);
			}
		}
		for (int i = 0; i < size; i++) {
			root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE,
					Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
			root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY,
					Priority.ALWAYS, VPos.CENTER, true));
		}
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				for (int row = 0; row < size; row++) {
					for (int col = 0; col < size; col++) {
						b[row][col] = new javafx.scene.control.Button();
						b[row][col].setStyle("-fx-background-color: black;");
						b[row][col].setBackground(javafx.scene.layout.Background.EMPTY);
					}
				}
				switch (event.getCode()) {
				case UP:
					if (currPos[1] != 0) {
						currPos[0] = currPos[0];
						currPos[1] = currPos[1] - 1;
					}
					break;
				case DOWN:
					if (currPos[1] != 6) {
						currPos[0] = currPos[0];
						currPos[1] = currPos[1] + 1;
					}
					break;
				case LEFT:
					if (currPos[0] != 0) {
						currPos[0] = currPos[0] - 1;
						currPos[1] = currPos[1];
					}
					break;
				case RIGHT:
					if (currPos[0] != 6) {
						currPos[0] = currPos[0] + 1;
						currPos[1] = currPos[1];
					}
					break;
				}
				b[currPos[0]][currPos[1]].setStyle("-fx-background-color: black;");
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}