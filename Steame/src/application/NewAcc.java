package application;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;

import javafx.embed.swing.JFXPanelBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewAcc {
	public NewAcc(Stage stage, Statement st, int x, int UserID)
	{
		GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
        main.setVgap(20);
        main.setHgap(20);
        main.setPadding(new Insets(10,10,10,10));
        
        JFXTextArea username = new JFXTextArea();
        username.setPromptText("Username");
        username.setLabelFloat(true);
        username.setMaxSize(100, 10);
        main.add(username, 5, 3);
        
        JFXTextArea password = new JFXTextArea();
        password.setPromptText("Password");
        password.setLabelFloat(true);
        password.setMaxSize(100, 10);
        main.add(password, 5, 5);
        
        JFXTextArea realname = new JFXTextArea();
        realname.setPromptText("Name");
        realname.setLabelFloat(true);
        realname.setMaxSize(100, 10);
        main.add(realname, 6, 3);
        
        JFXTextArea email = new JFXTextArea();
        email.setPromptText("Email");
        email.setLabelFloat(true);
        email.setMaxSize(100, 10);
        main.add(email, 6, 5);
        
        /*JFXTextArea phone = new JFXTextArea();
        phone.setPromptText("Phone #");
        phone.setLabelFloat(true);
        phone.setMaxSize(100, 10);
        main.add(phone, 7, 3);
        */
        
        Label phoneN = new Label("Phone #");
       
        main.add(phoneN, 7, 3);
        
        JFXSlider phone = new JFXSlider();
        phone.setMinHeight(50);
        phone.setMinWidth(300);
        phone.setMin(111111111);
        phone.setMax(999999999);
        main.add(phone,8, 3);
        
        JFXTextArea scname = new JFXTextArea();
        scname.setPromptText("Screen name");
        scname.setLabelFloat(true);
        scname.setMaxSize(100, 10);
        main.add(scname, 5, 7);
        
        Label what = new Label("What are you?");
        main.add(what, 7, 4);
        
        JFXCheckBox isDev = new JFXCheckBox();
        isDev.setText("Developer");
        main.add(isDev, 7, 5);
        
        JFXCheckBox isCus = new JFXCheckBox();
        isCus.setText("Gamer");
        main.add(isCus, 7, 6);
        
        JFXButton confirm = new JFXButton("Confirm");
        main.add(confirm, 5, 8);
        
        JFXButton acc = new JFXButton("Back");
        acc.getStyleClass().add("A");
        main.add(acc, 5, 9);
        
        acc.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(x==1) {
					new Library(stage, st, UserID);
				}
				else if(x==2) {
					try {
						new Login(stage, st);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return;
				
			}
		});
        
        confirm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				int UserID = (int)(Math.random()*Integer.MAX_VALUE);
				String sn = scname.getText();
				String rn = realname.getText();
				String em = email.getText();
				int pn = (int)phone.getValue();
				String pw = password.getText();
				boolean cf = isCus.isSelected();
				boolean df = isDev.isSelected();
				
				try {
					st.execute("INSERT INTO User (UserID,ScreenName,	RealName,	Email	,PhoneNumber,	Password	,Customer_Flag	,Developer_Flag	,DeveloperPage) "
							+ "VALUES ("+UserID+", '"+sn+"', '"+rn+"', '"+em+"', "+pn+", '"+em+"', "+cf+", "+df+", 'dd.com')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new Library(stage,st,UserID);
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
