import java.sql.*;


public class BusinessLogic {
	
	private Connection conn = null;    	//Connection Variable
	private Statement statement = null;		//SQL Statement variable
	private ResultSet res; //SQL ResultSet variable
	private String  dbURL = "jdbc:mysql://localhost:3306/csirdb?zeroDateTimeBehavior=convertToNull";	//DB URL
	
	
	/*	The Constructer creates
	 * 	a connection to our DB
	 * 	On the server by calling
	 * 	createConnection()
	 */
	public BusinessLogic()
	{
		createConnection();
	}
	
	
	
	/*	#Input: N/A
	 * 	#Process: Creates a connection to
	 * 	 our Database
	 * 	#Return: Void (N/A)
	 */
	public void createConnection()
	{
		try
        {
			Class.forName("com.mysql.jdbc.Driver");
           // Get a connection
            conn = DriverManager.getConnection(dbURL, "root", "root"); 
            System.out.println("Connected...");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
	}
	
	
	
	/*
	 * #Input: Scanned Number Plate
	 * #Process: Fetches the owner ID of
	 * 	the scanned vehicle's owner.
	 * #Output: The Owner's owner ID (Integer)
	 */
	public int getOwnerID(String NumberPlate)
	{
		int returnValue = -1;
		try {
			statement = conn.createStatement();
			res = statement.executeQuery("SELECT * FROM vehicle WHERE (number_plate = '" + NumberPlate + "')");
			if(res.next())
			{
				returnValue = Integer.parseInt(res.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	/*	
	 * #Input: id (Primary Key)	
	 * #Process: Gets the owner details of
	 * 	the specified ID.
	 * #Output: A string with the owner's
	 * 	details separated by newlines
	 * 
	 */
	public String getOwner(int id)
	{
		String returnValue = "";
		try {
			statement = conn.createStatement();
			res = statement.executeQuery("SELECT * FROM owner WHERE (owner_id = " + id + ")");
			if(res.next())
			{
				returnValue = "Name: "+res.getString(2)+"\nType: " + res.getString(3)+ "\nAddress: " + res.getString(4)+ "\nID OR Registration Num: " + res.getString(5) + "\n";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	
	public String getOwner(String IDNumber)
	{
		return "";
	}
	
	
	public String getVehicle(String NumberPlate)
	{
		return "";
	}
	
	public String getFeatureID(String NumberPlate)
	{
		return "";
	}
	
	
	public String getFeatures(int id)
	{
		return "";
	}
	
}
