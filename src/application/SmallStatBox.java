package application;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SmallStatBox extends HBox {
	private Label name;
	private Label amount;

	public SmallStatBox(String name) {

		this.name = new Label(name);
		this.name.setStyle("-fx-font-size: 13px;");
		this.name.setTextFill(Color.GRAY);
		
		this.amount = new Label();
		this.amount.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");
		this.amount.setTextFill(Color.WHITE);

		this.setSpacing(3);
		this.getChildren().addAll(this.name, this.amount);
	}
	
	public void setAmount(String amount) {
		this.amount.setText(amount);
	}
}
