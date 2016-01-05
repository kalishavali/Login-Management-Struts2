package DAOImpl;
import java.sql.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import DAO.LoginDAO;


public class LoginDAOImpl implements LoginDAO{
	
	public boolean getLoginValidation(String userName,String password){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	Statement stmt=con.createStatement();
	   	 	ResultSet res = stmt.executeQuery("Select username,password from Profile_1200030");
	       	while(res.next()){
	       		String user_name=res.getString("username");
	       		String pass=res.getString("password");
	       		if(userName.equals(user_name)&&password.equals(pass)){
	       			result=true;
	       		}
	       	}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
      }
	public boolean getRegister(String name,String gender,String username,String password,String email){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	 // the mysql insert statement
	    	 // the mysql insert statement
	    	boolean LoginCheck=getLoginValidation(username,password);
	    	if(!LoginCheck){
		    	String query = "insert into Profile_1200030 (name,gender,username,password,email) values (?,?,?,?,?)";
		 	   
		        // create the mysql insert preparedstatement
		        PreparedStatement preparedStmt = con.prepareStatement(query);
		        preparedStmt.setString (1, name);
		        preparedStmt.setString (2, gender);
		        preparedStmt.setString   (3, username);
		        preparedStmt.setString(4, password);
		        preparedStmt.setString    (5, email);
		   
		        // execute the preparedstatement
		        preparedStmt.execute();
		        result=true;
	    	}
	    	result=false;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	public boolean changePassword(String userName,String changePassword){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	 // the mysql insert statement
	        String query = "update Profile_1200030 set password=? where username=?";
	   
	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	        preparedStmt.setString (1, changePassword);
	        preparedStmt.setString (2, userName);
	   
	        // execute the preparedstatement
	        preparedStmt.execute();
	        result=true;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	public ArrayList<String> forgotPassword(String email){
		ArrayList<String> forgotDetails=new ArrayList<String>();
		SecureRandom random = new SecureRandom();  
	    String token = new BigInteger(130, random).toString(32);
	    
	    
	   final String from="kalishavali.rgukt@gmail.com";
	   final String password="hasanbhi";
	   final String to=email;
	   String subject="Kalishavali-Forgot Password Reset Link";
	   String html="http://localhost:9001/Login/resetPassword?token="+token;
	   String body="This is Your password Reset Link::\n"+"\n<a href='"+html+"'>"+html+"</a>";
//	   Properties properties = new Properties();
//	      properties.put("mail.smtp.host", "smtp.gmail.com");
//	      properties.put("mail.smtp.socketFactory.port", "465");
//	      properties.put("mail.smtp.socketFactory.class",
//	                     "javax.net.ssl.SSLSocketFactory");
//	      properties.put("mail.smtp.auth", "true");
//	      properties.put("mail.smtp.port", "465");
//	   
//	      boolean ret = true;
//	      try
//	      {
//	         Session session = Session.getDefaultInstance(properties, 
//	            new javax.mail.Authenticator() {
//	            protected PasswordAuthentication
//	            getPasswordAuthentication() {
//	            return new
//	            PasswordAuthentication(from, password);
//	            }});
//	         Message message = new MimeMessage(session);
//	         message.setContent(message, "text/html");
//	         message.setFrom(new InternetAddress(from));
//	         message.setRecipients(Message.RecipientType.TO,
//	            InternetAddress.parse(to));
//	         message.setSubject(subject);
//	         message.setText(body);
//	         
//	         Transport.send(message);
//	      }
//	      catch(Exception e)
//	      {
//	         ret = false;
//	         e.printStackTrace();
//	      }
	   try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	 // the mysql insert statement
	        String query = " update Profile_1200030 set token=? where email=?";
	 	   
	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	        preparedStmt.setString (1, token);
	        preparedStmt.setString (2, email);
	   
	        // execute the preparedstatement
	        preparedStmt.execute();
		}
		catch(Exception e){
			System.out.println(e);
		}
	   forgotDetails.add(html);
	      return forgotDetails;
	}
	public boolean resetPassword(String token,String password){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	 // the mysql insert statement
	        String query = "update Profile_1200030 set password=? where token=?";
	   
	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	        preparedStmt.setString (1, password);
	        preparedStmt.setString (2, token);
	   
	        // execute the preparedstatement
	        preparedStmt.execute();
	        result=true;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	public boolean checkMail(String email){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	Statement stmt=con.createStatement();
	   	 	ResultSet res = stmt.executeQuery("Select email from Profile_1200030");
	       	while(res.next()){
	       		String dbEmail=res.getString("email");
	       		if(email.equals(dbEmail)){
	       			result=true;
	       		}
	       	}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
}
