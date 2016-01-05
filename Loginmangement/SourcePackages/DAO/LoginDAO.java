package DAO;

import java.util.*;

public interface LoginDAO {
	public boolean getLoginValidation(String userName,String password);
	public boolean getRegister(String name,String gender,String username,String password,String email);
	public boolean changePassword(String userName,String changePassword);
	public ArrayList<String> forgotPassword(String email);
	public boolean resetPassword(String token,String password);
	public boolean checkMail(String email);
}
