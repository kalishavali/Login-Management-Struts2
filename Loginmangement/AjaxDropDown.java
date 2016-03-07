package authentication;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import Testing.Database_Access;

public class AjaxDropDown extends ActionSupport  {

	private static final long serialVersionUID = -8819352697303500472L;
	
	
	private Map<String,String> dropDownData;
	String sid="01",did="",mid="",pid="";
	HttpServletResponse response=ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session=request.getSession();
    
	public String dbDropDown() {
		//Getting Session Variables
		if(session.getAttribute("did")!=null && session.getAttribute("did")!=""){
			did=(String)session.getAttribute("did");
		}
		if(session.getAttribute("mid")!=null && session.getAttribute("mid")!=""){
			mid=(String)session.getAttribute("mid");
		}
		if(session.getAttribute("pid")!=null && session.getAttribute("pid")!=""){
			pid=(String)session.getAttribute("pid");
		}
		
		if(request.getParameter("did")!=null && request.getParameter("did")!=""){
			did=request.getParameter("did");
			session.setAttribute("did",did);
			dropDownData = new HashMap<String,String>();
			dropDownData=Database_Access.getDbMandals(sid, did)	;
		}
		else if(request.getParameter("mid")!=null && request.getParameter("mid")!=""){
			mid=request.getParameter("mid");
			session.setAttribute("mid",mid);
			dropDownData = new HashMap<String,String>();
			dropDownData=	Database_Access.getPanchayats(sid, did, mid);
		}
		else if(request.getParameter("pid")!=null && request.getParameter("pid")!=""){
			pid=request.getParameter("pid");
			session.setAttribute("pid",pid);
			dropDownData = new HashMap<String,String>();
			dropDownData=	Database_Access.getVillages(sid, did, mid, pid)	;
		}
		else{
			dropDownData = new HashMap<String,String>();
			dropDownData=	Database_Access.getDbDistricts(sid);
		}
		return SUCCESS;
	}
	public Map<String, String> getDropDownData() {
		return dropDownData;
	}
	public void setDropDownData(Map<String, String> dropDownData) {
		this.dropDownData = dropDownData;
	}
	
	
	
	

	

	

	
}