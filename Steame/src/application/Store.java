package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Store {
	public Store(Stage stage, Statement st, int UserID)
	{
		
        
        ArrayList<String> games = new ArrayList<String>();
        ArrayList<Integer> id = new ArrayList<Integer>();
        
        try {
			ResultSet rs = st.executeQuery("SELECT * FROM Game");
			
			while(rs.next())
			{
				games.add(rs.getString("Name"));
				String xd = rs.getString("GameFiles");
				id.add(rs.getInt("GameID"));
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        
        

         ListView<String> listView = new ListView<String>();
         
         listView.setPrefHeight(600);
        listView.setPrefWidth(300);
        
        for (int i = 0; i < games.size(); i++) {
       	 listView.getItems().add(games.get(i));
        }
        
        listView.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                	Image m = null;
               	try {
               		String loc = "Games/"+name+"/"+name+".jpg";
               	//	System.out.println(loc);
                     m = new Image(loc);
                     
               	}catch (Exception e) {
					e.printStackTrace();
				}
                    
                    imageView.setImage(m);
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    imageView.setPreserveRatio(true);
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });
         
        GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
        main.setVgap(20);
        main.setHgap(20);
        main.setPadding(new Insets(10,10,10,10));
        
        
        JFXButton library = new JFXButton("Library");
        library.getStyleClass().add("A");
        main.add(library, 13, 0);
        
        Label dl = new Label("Click To Download a game!");
        dl.minHeight(200);
       	dl.minWidth(200);
       
        main.add(dl, 0, 0);
       
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

        	
            @Override
            public void handle(MouseEvent event) {
            	dl.setText(listView.getSelectionModel().getSelectedItem()+" Downloaded!");
            	
            	try {
					st.execute("INSERT INTO PlaysGame (GameID_FK,	UserID_FK,	HoursLogged,	GameProgressState) "
							+ "VALUES ("+(id.get(listView.getSelectionModel().getSelectedIndex())+1)+", "+UserID+", 0,0)");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

       
        
        library.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Library(stage,st, UserID);
				return;
				
			}
		});
       
        
        main.add(listView, 0, 1);
        
        final Scene scene = new Scene(main, 800, 600);
        stage.setTitle("The People's Market");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
