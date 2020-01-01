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
import logic.exceptions.SellFailedException;
import logic.generators.base.Generator;

public class GeneratorTile extends HBox {

	private static final double BOX_WIDTH = 300;
	private static final double BOX_HEIGHT = 64;

	private Generator generator;
	private GeneratorDescriptionBox description;

	public GeneratorTile(Generator generator) {
		this.generator = generator;
		description = new GeneratorDescriptionBox(generator);

		ImageView generatorIcon = new ImageView(new Image(generator.getImagePath()));

		BackgroundImage storeTile = new BackgroundImage(new Image(PathStorage.STORETILE_PATH),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		AudioClip clickSound = new AudioClip(PathStorage.GENERATORBUY_SNDPATH);

		setBuy();

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
				if (BuyAndSellMenu.getMode() == 0) {
					try {
						generator.buy();
						clickSound.play();
						description.setAmount(generator.getAmountOwned());
						setBuy();
						CookieBlock.getInstance().setAmount();
						CookieBlock.getInstance().setPerSecond();
					} catch (PurchaseFailedException e) {
						System.err.println(e);
					}
				} else {
					try {
						generator.sell();
						clickSound.play();
						description.setAmount(generator.getAmountOwned());
						setSell();
						CookieBlock.getInstance().setAmount();
						CookieBlock.getInstance().setPerSecond();
					} catch (SellFailedException e) {
						System.err.println(e);
					}
				}
			}
		});

		this.setAlignment(Pos.CENTER_LEFT);
		this.setBackground(new Background(storeTile));
		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
		this.getChildren().addAll(generatorIcon, description);
	}

	public void setBuy() {
		description.setBuyPrice(generator.getCurrentPrice());
	}

	public void setSell() {
		description.setSellPrice(generator.getSellPrice());
	}
}
