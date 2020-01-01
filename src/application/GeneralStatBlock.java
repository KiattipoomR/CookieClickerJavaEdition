package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Player;
import logic.PrintBigNum;

public class GeneralStatBlock extends VBox {

	private static final GeneralStatBlock INSTANCE = new GeneralStatBlock();

	private SmallStatBox currentCookies;
	private SmallStatBox totalCookies;
	private SmallStatBox totalGenerators;
	private SmallStatBox totalPerSecond;
	private SmallStatBox perClick;
	private SmallStatBox totalClick;
	private SmallStatBox handmadeCookies;

	private GeneralStatBlock() {
		Label generalTitle = new Label("General");
		generalTitle.setStyle("-fx-font-size: 23px;");
		generalTitle.setPadding(new Insets(0, 0, 5, 0));
		generalTitle.setTextFill(Color.WHITE);

		currentCookies = new SmallStatBox("Cookie(s) in bank :");
		totalCookies = new SmallStatBox("Cookie(s) baked :");
		totalGenerators = new SmallStatBox("Generator(s) owned :");
		totalPerSecond = new SmallStatBox("Cookie(s) per second :");
		perClick = new SmallStatBox("Cookie(s) per click :");
		totalClick = new SmallStatBox("Cookie clicks :");
		handmadeCookies = new SmallStatBox("Handmade cookie(s) :");
		update();

		VBox generalDetail = new VBox();
		generalDetail.setSpacing(5);
		generalDetail.setPadding(new Insets(0, 0, 10, 0));
		generalDetail.getChildren().addAll(currentCookies, totalCookies, totalGenerators, totalPerSecond, perClick,
				totalClick, handmadeCookies);

		this.getChildren().addAll(generalTitle, generalDetail);
	}

	public static GeneralStatBlock getInstance() {
		return INSTANCE;
	}

	public void setCurrentCookies() {
		currentCookies.setAmount(PrintBigNum.PrintBigNumForCookie(Player.getInstance().getCurrentCookies()));
	}

	public void setTotalCookies() {
		totalCookies.setAmount(PrintBigNum.PrintBigNumForCookie(Player.getInstance().getTotalCookies()));
	}

	public void setTotalGenerators() {
		totalGenerators.setAmount(Integer.toString(Player.getInstance().getTotalGenerators()));
	}

	public void setTotalPerSecond() {
		totalPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Player.getInstance().getTotalPerSecond()));
	}

	public void setPerClick() {
		perClick.setAmount(PrintBigNum.PrintBigNumForCookie(Player.getInstance().getPerClick()));
	}

	public void setTotalClick() {
		totalClick.setAmount(Integer.toString(Player.getInstance().getTotalClick()));
	}

	public void setHandmadeCookies() {
		handmadeCookies.setAmount(PrintBigNum.PrintBigNumForCookie(Player.getInstance().getHandmadeCookies()));
	}

	public void update() {
		setCurrentCookies();
		setTotalCookies();
		setTotalGenerators();
		setTotalPerSecond();
		setPerClick();
		setTotalClick();
		setHandmadeCookies();
	}
}
