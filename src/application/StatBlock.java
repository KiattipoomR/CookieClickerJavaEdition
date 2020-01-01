package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.PathStorage;

public class StatBlock extends VBox {

	private static final StatBlock INSTANCE = new StatBlock();
	private static final double BOX_WIDTH = 368;

	private StatBlock() {
		BackgroundImage blackBg = new BackgroundImage(new Image(PathStorage.BLACKBG_PATH), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Label statTitle = new Label("STATISTICS");
		statTitle.setStyle("-fx-font-size: 25px;");
		statTitle.setTextFill(Color.WHITE);

		VBox titleBox = new VBox();
		titleBox.getChildren().add(statTitle);
		titleBox.setAlignment(Pos.CENTER);
		titleBox.setPadding(new Insets(0, 0, 5, 0));

		this.setPrefWidth(BOX_WIDTH);
		this.setPadding(new Insets(10));
		this.setBackground(new Background(blackBg));
		this.getChildren().addAll(titleBox, GeneralStatBlock.getInstance(), UpgradeStatBlock.getInstance());
	}

	public static StatBlock getInstance() {
		return INSTANCE;
	}
	
	public void update() {
		GeneralStatBlock.getInstance().update();
		UpgradeStatBlock.getInstance().update();
	}
}
