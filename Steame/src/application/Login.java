package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
	public Login(Stage stage, Statement st) throws FileNotFoundException
	{
		GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
        main.setVgap(20);
        main.setHgap(20);
        main.setPadding(new Insets(10,10,10,10));

        int xc = 15;
        int yc = 6;

        JFXTextArea username = new JFXTextArea();
        username.setPromptText("Username");
        username.setLabelFloat(true);
        username.setMaxSize(200, 10);
        main.add(username, xc, yc);
        
        
        JFXPasswordField password = new JFXPasswordField();
        password.setPromptText("Password");
        password.setLabelFloat(true);
        password.setMaxSize(200, 10);
        main.add(password, xc, yc+2);
        
        JFXButton login = new JFXButton("Login");
        JFXButton acc = new JFXButton("New Account");
        acc.getStyleClass().add("A");
        main.add(login, xc, yc+2+1);
        main.add(acc, xc, yc+2+2);
        
        acc.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new NewAcc(stage,st,2,0);
				return;
				
			}
		});
        
        login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				String n = username.getText();
				String s = password.getText();
				
				try {
					ResultSet rs = st.executeQuery("SELECT * FROM User WHERE ScreenName='"+n+"'");
					
					while(rs.next())
					{
						String pass = rs.getString("Password");
						int UserID = rs.getInt("UserId");
						
						if(!pass.isEmpty()&& pass.equals(s))
						{
							new Library(stage,st,UserID);
						}
						else
						{
							
						}
					}
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return;
				
			}
		});
        
        Image image = new Image(new FileInputStream("The Crew.png"));
        ImageView imageView = new ImageView(image); 
        
        main.add(imageView, xc+2, yc+8);
        
        final Scene scene = new Scene(main, 800, 600);
        stage.getIcons().add(new Image(Login.class.getResourceAsStream( "icon.png" ))); 
        stage.setTitle("The People's Market");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
