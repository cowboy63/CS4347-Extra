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
		test();
	}
	
	void test()
	{
		// variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Step 1: Loading or registering Oracle JDBC driver class
        try {
        	
        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        	
        	
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            String msAccDB = "C:/Users/Ari/Desktop/Gamestore.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL); 

            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            
            //statement.execute("INSERT INTO User (UserID,ScreenName,	RealName,	Email	,PhoneNumber,	Password	,Customer_Flag	,Developer_Flag	,DeveloperPage) VALUES (445, 'rem', 'rem', 'aa@sc', '7727', '33dsd', true, true, 'dd.com')");
           //statement.executeUpdate("DELETE FROM User WHERE USERID=445");
            System.out.println("ID\tName\t\t\tAge\tMatches");
            System.out.println("==\t================\t===\t=======");
            
          resultSet = statement.executeQuery("SELECT * FROM User");
          
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {

            // Step 3: Closing database connection
            try {
                if(null != connection) {

                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
}
