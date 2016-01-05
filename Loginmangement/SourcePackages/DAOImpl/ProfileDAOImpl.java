package DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ProfileDAO;

public class ProfileDAOImpl implements ProfileDAO{

	@Override
	public ArrayList<String> getProfile(String userName) {
		ArrayList<String> details=new ArrayList<String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	PreparedStatement pre=con.prepareStatement("select * from Profile_1200030 where username=?");
            pre.setString(1, userName);
            ResultSet res=pre.executeQuery();
            while(res.next()){
                details.add(res.getString(1));
                details.add(res.getString(2));
                details.add(res.getString(3));
                details.add(res.getString(4));
                details.add(res.getString(5));
                details.add(res.getString(6));
                details.add(res.getString(7));
                details.add(res.getString(8));
                details.add(res.getString(9));
                details.add(res.getString(10));
            }
		}
		catch(Exception e){
			System.out.println(e);
		}
		return details;
	}
	public boolean editProfile(String userName,String email,String gender,String dateOfBirth,String phone,String address,String designation){
		boolean result=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	 // the mysql insert statement
	    	 // the mysql insert statement
	    	String query = "update Profile_1200030 set email=?,gender=?,dateofbirth=?,phone=?,address=?,designation=? where username=?";
	 	   
	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	        preparedStmt.setString (1, email);
	        preparedStmt.setString (2, gender);
	        preparedStmt.setString (3, dateOfBirth);
	        preparedStmt.setString (4, phone);
	        preparedStmt.setString (5, address);
	        preparedStmt.setString (6, designation);
	        preparedStmt.setString (7, userName);
	   
	        // execute the preparedstatement
	        preparedStmt.execute();
	        result=true;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
		
	}

}
