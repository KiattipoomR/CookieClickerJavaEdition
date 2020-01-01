package application;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.PathStorage;
import logic.Player;
import logic.PrintBigNum;

public class CookieBlock extends VBox {

	private static final CookieBlock INSTANCE = new CookieBlock();
	private static final double BOX_WIDTH = 300;

	private Label name;
	private Label amount;
	private Label perSecond;

	private CookieBlock() {
		name = new Label();
		setName();
		amount = new Label();
		setAmount();
		perSecond = new Label();
		setPerSecond();

		AudioClip clickSound = new AudioClip(PathStorage.COOKIECLICK_SNDPATH);
		DropShadow effect2 = new DropShadow();

		name.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
		name.setTextFill(Color.WHITE);
		name.setEffect(effect2);

		name.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Glow effect1 = new Glow(1);
				effect1.setInput(effect2);
				name.setEffect(effect1);
			}
		});

		name.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				name.setEffect(effect2);
			}
		});

		name.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TextInputDialog nameChange = new TextInputDialog(Player.getInstance().getPlayerName());
				nameChange.setHeaderText("What should your bakery's name be?");
				nameChange.setTitle("Name your bakery");
				nameChange.setGraphic(new ImageView(new Image(PathStorage.ICON_PATH)));

				Stage tempStage = (Stage) nameChange.getDialogPane().getScene().getWindow();
				tempStage.getIcons().add(new Image(PathStorage.ICON_PATH));

				Optional<String> result = nameChange.showAndWait();

				result.ifPresent(playerName -> {
					if (!playerName.equals("")) {
						Player.getInstance().setPlayerName(playerName);
						setName();
					}
				});
			}
		});

		amount.setStyle("-fx-font-size: 28px;");
		amount.setTextFill(Color.WHITE);

		perSecond.setStyle("-fx-font-size: 16px;");
		perSecond.setTextFill(Color.WHITE);

		ImageView bigCookie = new ImageView(new Image(PathStorage.BIGCOOKIE_PATH));

		bigCookie.setFitHeight(200);
		bigCookie.setFitWidth(200);

		bigCookie.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bigCookie.setFitHeight(220);
				bigCookie.setFitWidth(220);
			}
		});

		bigCookie.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				clickSound.play();
				bigCookie.setFitHeight(200);
				bigCookie.setFitWidth(200);
				Player.getInstance().clickCookie();
				setAmount();
			}
		});

		ImageView milkPlain = new ImageView(new Image(PathStorage.MILK_PATH));
		milkPlain.setFitHeight(300);
		milkPlain.setFitWidth(300);

		VBox playerBlock = new VBox();
		playerBlock.setPrefHeight(150);
		playerBlock.setAlignment(Pos.CENTER);
		playerBlock.getChildren().addAll(name, amount, perSecond);

		VBox bigCookieBlock = new VBox();
		bigCookieBlock.setPrefHeight(240);
		bigCookieBlock.setAlignment(Pos.CENTER);
		bigCookieBlock.getChildren().add(bigCookie);

		VBox milkBlock = new VBox();
		milkBlock.setPrefHeight(300);
		milkBlock.getChildren().add(milkPlain);

		this.setPrefWidth(BOX_WIDTH);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(playerBlock, bigCookieBlock, milkBlock);
	}

	public static CookieBlock getInstance() {
		return INSTANCE;
	}

	public void setName() {
		this.name.setText("  " + Player.getInstance().getPlayerName() + "'s Bakery  ");
	}

	public void setAmount() {
		this.amount.setText(PrintBigNum.PrintBigNumForCookie(Player.getInstance().getCurrentCookies()) + " cookie(s)");
	}

	public void setPerSecond() {
		this.perSecond.setText(
				"per second : " + PrintBigNum.PrintBigNumForPerSecond(Player.getInstance().getTotalPerSecond()));
	}
}
