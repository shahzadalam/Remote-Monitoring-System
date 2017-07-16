package windowsRemote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.net.*;



public class remotecall {
	private String url ="jdbc:sqlserver://Lenovo-PC;databaseName=RMS";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String userName = "sa"; 
    private String password = "123";
	public  void addUser(String hostname,String username,String userpassword) {
		Connection conn = null;
      
		
        Statement stmt;
        try
        {

        Class.forName(driver);
        conn = DriverManager.getConnection(url,userName,password);
        String query = "insert into login (hostname,username,password) values('"+hostname+"','"+username+"','"+userpassword+"')";
        stmt = conn.createStatement();
        stmt.executeUpdate(query);

           System.out.println("success");

        conn.close();
      
        } catch (Exception e) {
        e.printStackTrace();
        }

	}
	public ArrayList<String> getUser()
	{
		ArrayList<String> user = new ArrayList<>();
		Connection conn = null;
        Statement stmt;
        try
        {

        Class.forName(driver);
        conn = DriverManager.getConnection(url,userName,password);
        stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT distinct hostname FROM login");
       while (rs.next()) {
           //String name = rs.getString(1);
           user.add(rs.getString(1));
        }
        conn.close();
        System.out.println("success");
        return user;
      
        } catch (Exception e) {
        e.printStackTrace();
        user.add("Database server is not active please check connection !!!!!");
        return user;
        }
	
	}
	public ArrayList<String> getUsername()
	{
		ArrayList<String> user = new ArrayList<>();
		Connection conn = null;
        Statement stmt;
        try
        {

        Class.forName(driver);
        conn = DriverManager.getConnection(url,userName,password);
        stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT distinct username FROM login");
       while (rs.next()) {
           //String name = rs.getString(1);
           user.add(rs.getString(1));
        }
        conn.close();
        System.out.println("success");
        return user;
      
        } catch (Exception e) {
        e.printStackTrace();
        user.add("Database server is not active please check connection !!!!!");
        return user;
        }
	
	}
	
	
	
	
	

	public String getpassword(String ip)
	{
		String pass="";
		if(ip.equals("10.100.53.88"))
			pass="pgadmin11";
		else if(ip.equals("10.100.53.101"))
			pass="7276482594";
		else if(ip.equals("10.100.53.1"))
			pass="pgadmin15";
		else
			System.out.println("!!!!!Cant fetch passwords");
			return pass;
		
	}
	public String getuser(String ip)
	{
		String user="";
		System.out.println(ip);
		if(ip.equals("10.100.53.88"))
			user="pgadmin11";
		else if(ip.equals("10.100.53.101"))
			user="arpit";
		else if(ip.equals("10.100.53.1"))
			user="pgadmin15";
		else
			System.out.println("--");
			return user;
		
	}
	
	

	  
  
}
