package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Payment {
	public Payment(Stage stage) {
		GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
	    main.setVgap(20);
	    main.setHgap(20);
	    main.setPadding(new Insets(10,10,10,10));
	    
	    JFXTextArea address = new JFXTextArea();
	    address.setPromptText("Billing address");
	    address.setLabelFloat(true);
	    address.setMaxSize(100, 10);
	    main.add(address, 5, 3);
	    
	    JFXTextArea bname = new JFXTextArea();
	    bname.setPromptText("Billing name");
	    bname.setLabelFloat(true);
	    bname.setMaxSize(100, 10);
	    main.add(bname, 5, 5);
	    
	    JFXTextArea card = new JFXTextArea();
	    card.setPromptText("Card number");
	    card.setLabelFloat(true);
	    card.setMaxSize(100, 10);
	    main.add(card, 6, 3);
	    
	    
	    JFXTextArea exp = new JFXTextArea();
	    exp.setPromptText("Exp.");
	    exp.setLabelFloat(true);
	    exp.setMaxSize(100, 10);
	    main.add(exp, 6, 5);
	    
	    JFXTextArea routing = new JFXTextArea();
	    routing.setPromptText("Routing number");
	    routing.setLabelFloat(true);
	    routing.setMaxSize(100, 10);
	    main.add(routing, 7, 3);
	    
	    
	    JFXTextArea account = new JFXTextArea();
	    account.setPromptText("Account Number");
	    account.setLabelFloat(true);
	    account.setMaxSize(100, 10);
	    main.add(account, 7, 5);
	    
	    JFXButton acc = new JFXButton("Back");
        acc.getStyleClass().add("A");
        main.add(acc, 5, 7);
        
        acc.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Library(stage);
				return;
				
			}
		});
	    
	    
	    final Scene scene = new Scene(main, 800, 600);
	    stage.setTitle("The People's Market");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
