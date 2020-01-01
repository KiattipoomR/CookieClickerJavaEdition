package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import logic.PathStorage;
import logic.exceptions.PurchaseFailedException;
import logic.upgrades.base.Upgrade;

public class UpgradeTile extends HBox {

	private static final double BOX_WIDTH = 300;
	private static final double BOX_HEIGHT = 64;

	private Upgrade upgrade;
	private UpgradeDescriptionBox description;

	public UpgradeTile(Upgrade upgrade) {
		this.upgrade = upgrade;
		description = new UpgradeDescriptionBox(upgrade);

		ImageView upgradeIcon = new ImageView(new Image(this.upgrade.getImagePath()));

		BackgroundImage storeTile = new BackgroundImage(new Image(PathStorage.STORETILE_PATH),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		AudioClip clickSound = new AudioClip(PathStorage.GENERATORBUY_SNDPATH);

		setUpgrade();

		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InnerShadow effect = new InnerShadow();
				effect.setRadius(30);
				setEffect(effect);
			}
		});

		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
				try {
					upgrade.buy();
					clickSound.play();
					setUpgrade();
					CookieBlock.getInstance().setAmount();
					CookieBlock.getInstance().setPerSecond();
				} catch (PurchaseFailedException e) {
					System.err.println(e);
				}
			}
		});

		this.setAlignment(Pos.CENTER_LEFT);
		this.setBackground(new Background(storeTile));
		this.setMaxSize(BOX_WIDTH, BOX_HEIGHT);
		this.getChildren().addAll(upgradeIcon, description);
	}

	public void setUpgrade() {
		description.setAmountCondition(upgrade);
		description.setPrice(upgrade.getUpgradePrice());
	}
}
