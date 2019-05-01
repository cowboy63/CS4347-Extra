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
	
	
	
        // Step 1: Loading or registering Oracle JDBC driver class
        try {
        	
        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        	
        	
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        
            String msAccDB = "C:/Users/Ari/Desktop/Gamestore.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 

            Connection connection = DriverManager.getConnection(dbURL); 

            Statement statement = connection.createStatement();

            
        	new Login(stage, statement);
           //new Store(stage, statement, 666480691);
           // statement.execute("INSERT INTO User (UserID,ScreenName,	RealName,	Email	,PhoneNumber,	Password	,Customer_Flag	,Developer_Flag	,DeveloperPage) VALUES (445, 'rem', 'rem', 'aa@sc', '7727', '33dsd', true, true, 'dd.com')");
           // statement.executeUpdate("DELETE FROM User WHERE USERID=445");
           //  statement.close();
          //   connection.close();
           
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
}
