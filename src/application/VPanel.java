package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import logic.PathStorage;

public class VPanel extends VBox {

	private static final double BOX_WIDTH = 16;

	public VPanel() {
		BackgroundImage vPanel = new BackgroundImage(new Image(PathStorage.VPANEL_PATH), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		this.setPrefWidth(BOX_WIDTH);
		this.setBackground(new Background(vPanel));
	}
}
