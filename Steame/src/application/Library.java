package application;

import java.io.FileNotFoundException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Library {
	private static final String ITEM = "Item ";
    private int counter = 0;
    
    private final Image IMAGE_RUBY  = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png");
    private final Image IMAGE_APPLE  = new Image("http://findicons.com/files/icons/832/social_and_web/64/apple.png");
    private final Image IMAGE_VISTA  = new Image("http://antaki.ca/bloom/img/windows_64x64.png");
    private final Image IMAGE_TWITTER = new Image("http://files.softicons.com/download/social-media-icons/fresh-social-media-icons-by-creative-nerds/png/64x64/twitter-bird.png");

    private Image[] listOfImages = {IMAGE_RUBY, IMAGE_APPLE, IMAGE_VISTA, IMAGE_TWITTER};

	public Library(Stage stage)
	{
		JFXListView<Label> list = new JFXListView<>();
        for (int i = 0; i < 4; i++) {
            list.getItems().add(new Label(ITEM + i+10));
        }
        list.getStyleClass().add("mylistview");

         ListView<String> listView = new ListView<String>();
         
         listView.setPrefHeight(600);
        listView.setPrefWidth(300);
         
       
         for (int i = 0; i < 30; i++) {
        	 listView.getItems().add("s");
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
                     if(name.equals("s"))
                         imageView.setImage(listOfImages[0]);
                     setText(name);
                     setGraphic(imageView);
                 }
             }
         });
         
         listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
            }
        });

        GridPane main = new GridPane();
		main.getStylesheets().add("application/application.css");
        main.setVgap(20);
        main.setHgap(20);
        main.setPadding(new Insets(10,10,10,10));
       
        
        JFXButton store = new JFXButton("Store");
        store.getStyleClass().add("A");
        main.add(store, 4, 0);
        
        JFXButton account = new JFXButton("Account");
        account.getStyleClass().add("A");
        main.add(account, 7, 0);
        
        JFXButton payment = new JFXButton("Pay Info");
        payment.getStyleClass().add("A");
        main.add(payment, 10, 0);
        
        
        JFXButton logout = new JFXButton("Log out");
        logout.getStyleClass().add("A");
        main.add(logout, 13, 0);
        
        main.add(listView, 0, 1);
        
        account.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new NewAcc(stage,1);
				return;
				
			}
		});
        
        logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					new Login(stage);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
				
			}
		});
        
        payment.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Payment(stage);
				return;
				
			}
		});
        
        store.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Store(stage);
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
