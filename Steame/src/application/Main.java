package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		new Login(stage);
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
}
