package application;

import java.math.BigDecimal;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.PathStorage;
import logic.PrintBigNum;
import logic.upgrades.PlayerUpgrade;
import logic.upgrades.base.Upgrade;

public class UpgradeDescriptionBox extends VBox {

	private static final double BOX_WIDTH = 190;
	private static final double BOX_HEIGHT = 50;
	private static final Color GREEN = Color.web("#61F161FF");

	private Label name;
	private Label amountCondition;
	private Label price;

	public UpgradeDescriptionBox(Upgrade upgrade) {
		name = new Label(upgrade.getName());
		amountCondition = new Label();
		setAmountCondition(upgrade);
		price = new Label();
		setPrice(upgrade.getUpgradePrice());

		ImageView cookieIcon = new ImageView(new Image(PathStorage.ICON_PATH));
		HBox iconAndPrice = new HBox();

		name.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		name.setTextFill(Color.WHITESMOKE);
		name.setEffect(new DropShadow(5, Color.BLACK));

		amountCondition.setStyle("-fx-font-size: 12px;");

		price.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
		price.setEffect(new DropShadow(3, Color.BLACK));

		iconAndPrice.setAlignment(Pos.CENTER_LEFT);
		iconAndPrice.setSpacing(5);

		iconAndPrice.getChildren().addAll(cookieIcon, price);

		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().addAll(name, amountCondition, iconAndPrice);
	}

	public void setAmountCondition(Upgrade upgrade) {
		if (upgrade.getUpgradeLevel() < 5) {
			if (upgrade.getGenerator() != null) {
				amountCondition
						.setText("Requires " + upgrade.getAmountCondition() + "x " + upgrade.getGenerator().getName());
			} else {
				PlayerUpgrade playerUpgrade = (PlayerUpgrade) upgrade;
				amountCondition.setText("Requires "
						+ PrintBigNum.PrintBigNumForCookie(playerUpgrade.getHandmadeCondition()) + " handmade cookies");
			}
		} else {
			amountCondition.setText("This upgrade is maxed out.");
		}
	}

	public void setPrice(BigDecimal price) {
		this.price.setTextFill(GREEN);
		this.price.setText(PrintBigNum.PrintBigNumForCookie(price));
	}
}
