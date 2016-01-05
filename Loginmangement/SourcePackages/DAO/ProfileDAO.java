package DAO;

import java.util.ArrayList;

public interface ProfileDAO {
	public ArrayList<String> getProfile(String userName);
	public boolean editProfile(String userName,String email,String gender,String dateOfBirth,String phone,String address,String designation);

}
