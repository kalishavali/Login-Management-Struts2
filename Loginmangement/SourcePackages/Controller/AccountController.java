package authentication;
 
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
 
import com.opensymphony.xwork2.ActionSupport;
import DAO.*;
import DAOImpl.*;
 
public class AuthenticationAction extends ActionSupport implements SessionAware {
     
    private Map<String, Object> sessionMap;
    private String userName;
    private String password;
    private String name;
    private String gender;
    private String email;
    private ArrayList<String> details;
    private String changePassword;
    private String changePassword1;
    private ArrayList<String> forgotDetails;
    private String token;
    private String dateOfBirth;
    private String phone;
    private String address;
    private String designation;
   
 
    public String login() {
        String loggedUserName = null;
        String dbUsername;
        String dbPassword;
 
        // check if the userName is already stored in the session
        if (sessionMap.containsKey("userName")) {
            loggedUserName = (String) sessionMap.get("userName");
        }
        if (loggedUserName != null) {
            return SUCCESS; // return welcome page
        }
         
        // if no userName stored in the session,
        // check the entered userName and password
        
        if (userName != null && password != null ) {
        	LoginDAO dao=new LoginDAOImpl();
        	boolean result=dao.getLoginValidation(userName,password);
        	if(result){
        		// add userName to the session
        		sessionMap.put("userName", userName);
        		return SUCCESS; // return welcome page
        	}
        	addActionError("Username or Password is Not Correct");

        }
         
        // in other cases, return login page
        return INPUT;
    }
     
    public String logout() {
    	HttpServletResponse response=null;
        response=ServletActionContext.getResponse();
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "0"); 
        // remove userName from the session
        if (sessionMap.containsKey("userName")) {
            sessionMap.remove("userName");
            
        }
        return SUCCESS;
    }
    public String register(){
    	if(name!=null && gender!=null && userName!=null && password!=null && password!=null){
	      	LoginDAO dao=new LoginDAOImpl();
	    	boolean result=dao.getRegister(name,gender,userName,password,email);
	    	if(result){
	    		sessionMap.put("userName", userName);
	    		return SUCCESS;
	    	}
	    	addActionError("User Already Exit.");
	    	
    	}
    	return INPUT;
    }
    public String profile(){
    	String profileUser=(String) sessionMap.get("userName");
	    if(profileUser!=null){
	        ProfileDAO dao=new ProfileDAOImpl();
	        details=dao.getProfile(profileUser);
	        if(details!=null){
	            return SUCCESS;
	        }
        }
        return INPUT;
    }
    public String changePassword(){
    	String currentUser=(String) sessionMap.get("userName");
    	if(currentUser!=null && changePassword!=null){
    		LoginDAO dao=new LoginDAOImpl();
    		boolean result=dao.changePassword(currentUser,changePassword);
    		if(result){
    			return SUCCESS;
    		}
    	}
    	return INPUT;
    }
    public String forgotPassword(){
    	if(email!=null){
	    	LoginDAO dao=new LoginDAOImpl();
	    	boolean mailCheck=dao.checkMail(email);
	    	if(mailCheck){
		    	forgotDetails=dao.forgotPassword(email);
		    	if(forgotDetails!=null){
		    		return SUCCESS;
		    	}
	    	}
	    	addActionError("Your Email is Not Correct or Not Registered");
    	}
    	return INPUT;
    }
    public String resetPassword(){
    	if(token!=null && changePassword!=null){
	    	LoginDAO dao=new LoginDAOImpl();
	    	boolean result=dao.resetPassword(token,changePassword);
	    	if(result){
	    		return SUCCESS;
	    	}
    	}
    	return INPUT;
    }
    public String editProfile(){
    	String currentUser=(String) sessionMap.get("userName");
    	if(currentUser!=null){
    		ProfileDAO dao=new ProfileDAOImpl();
	        details=dao.getProfile(currentUser);
	        if(email!=null && gender!=null && dateOfBirth!=null && phone!=null && address!=null && designation!=null){
	        	boolean result=dao.editProfile(currentUser,email,gender,dateOfBirth,phone,address,designation);
	        	if(result){
	        		return SUCCESS;
	        	}
	    	}
	    	return INPUT;
    	}
    	return LOGIN;
    }
   
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
     
    public void setUserName(String userName) {
        this.userName = userName;
    }
     
    public void setPassword(String password) {
        this.password = password;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<String> getDetails(){
        return details;
    }
    public void setDetails(ArrayList<String> details){
        this.details=details;
    }

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	public String getChangePassword1() {
		return changePassword1;
	}

	public void setChangePassword1(String changePassword1) {
		this.changePassword1 = changePassword1;
	}

	public ArrayList<String> getForgotDetails() {
		return forgotDetails;
	}

	public void setForgotDetails(ArrayList<String> forgotDetails) {
		this.forgotDetails = forgotDetails;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
