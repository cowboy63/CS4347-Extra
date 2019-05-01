package application;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Store {
	public Store(Stage stage)
	{
		GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
        main.setVgap(20);
        main.setHgap(20);
        main.setPadding(new Insets(10,10,10,10));
        
        stage.setTitle("The People's Market");
       // stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
