package authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Testing.Database_Access;

import com.opensymphony.xwork2.ActionSupport;

public class Reports extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletResponse response=ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();
	private List<Person> personList = new ArrayList<Person>();;
	private Map<String,String> resList=new HashMap<String,String>();
	String did="",mid="",pid="";
	
	public String dbDistricts(){
		String sid="01";
	
			resList=Database_Access.getDbDistricts(sid);
		
		if(request.getParameter(did)!=null){
			did=request.getParameter(did);
			resList=Database_Access.getDbMandals(did,sid);
		}
	    return SUCCESS;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public Map<String, String> getResList() {
		return resList;
	}

	public void setResList(Map<String, String> resList) {
		this.resList = resList;
	}

	

	

	



	

	

	/*public String getDefaultDistrict() {
		return "Select State";
	}

	public void setDistrict(String district) {
		this.district = district;
	}*/

	

}
