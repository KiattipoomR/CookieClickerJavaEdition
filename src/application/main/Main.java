package application.main;

import application.CookieBlock;
import application.StatBlock;
import application.StoreBlock;
import application.VPanel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.GameLoop;
import logic.PathStorage;

public class Main extends Application {

	private static final double WINDOW_WIDTH = 1000;
	private static final double WINDOW_HEIGHT = 690;

	private Thread gameRunner = new Thread(new GameLoop());
	private MediaPlayer bgm;

	@Override
	public void start(Stage primaryStage) {

		VPanel vPane = new VPanel();
		VPanel vPane2 = new VPanel();

		HBox root = new HBox();

		BackgroundImage gamebg = new BackgroundImage(new Image(PathStorage.GAMEBG_PATH), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(gamebg));
		root.getChildren().addAll(CookieBlock.getInstance(), vPane, StatBlock.getInstance(), vPane2, StoreBlock.getInstance());

		bgm = new MediaPlayer(new Media(PathStorage.GAMEBGM_SNDPATH));
		bgm.setCycleCount(MediaPlayer.INDEFINITE);
		bgm.play();
		
		primaryStage.setTitle("Cookie Clicker");
		primaryStage.getIcons().add(new Image(PathStorage.ICON_PATH));
		primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
		primaryStage.setWidth(WINDOW_WIDTH);
		primaryStage.setHeight(WINDOW_HEIGHT);
		primaryStage.setResizable(false);
		primaryStage.show();
		gameRunner.start();
	}

	@Override
	public void stop() throws Exception {
		gameRunner.interrupt();
		Platform.exit();
	}

	public static void main(String[] args) {
		launch(args);
	}
}