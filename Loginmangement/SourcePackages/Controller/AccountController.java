package Controller;
import com.opensymphony.xwork2.*;
import entities.*;
import model.*;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts2.interceptor.*;

public class AccountController extends ActionSupport implements ServletResponseAware,ServletRequestAware{
    private Account account;
    private String errorMessage="";
    private boolean remember=false;
    public boolean isRemember(){
        return remember;
    }
    public void setRemember(boolean remember){
        this.remember=remember;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account=account;
    }
    public String execute() throws Exception{
        Account account=checkCookie();
        if(account==null)
            return "login";
        else{
            AccountModel accModel=new AccountModel();
            if(accModel.login(account.getUsername(),account.getPassword())){
                Map<String,Object> session=ActionContext.getContext().getSession();
                session.put("username",account.getUsername());
                return "success";
            }
            else{
                this.errorMessage="Account's Invalid";
                return "login";
            }
        }
    }
    public String login(){
        AccountModel accModel=new AccountModel();
        if(accModel.login(account.getUsername(),account.getPassword())){
            Map<String,Object> session=ActionContext.getContext().getSession();
            session.put("username",account.getUsername());
            if(this.remember){
               Cookie ckUsername=new Cookie("username",account.getUsername());
               ckUsername.setMaxAge(3600);
               servletResponse.addCookie(ckUsername);
               Cookie ckPassword=new Cookie("password",account.getPassword());
               ckPassword.setMaxAge(3600);
               servletResponse.addCookie(ckPassword);
            }
            return "success";
        }else{
            this.errorMessage="Account's Invalid";
            return "login";
        }
    }
    public String logout(){
       //Remove Session
         Map<String,Object> session=ActionContext.getContext().getSession();
         session.remove("username");
        //Remove Cookie
         for(Cookie ck:servletRequest.getCookies()){
             if(ck.getName().equalsIgnoreCase("username")){
                 ck.setMaxAge(0);
                 servletResponse.addCookie(ck);
             }
             if(ck.getName().equalsIgnoreCase("password")){
                 ck.setMaxAge(0);
                 servletResponse.addCookie(ck);
             }
         }
         
        return "success";
    }
    private Account checkCookie(){
        Account account=null;
        String username="",password="";
        for(Cookie ck:servletRequest.getCookies()){
            if(ck.getName().equalsIgnoreCase("username"))
                username=ck.getValue();
             if(ck.getName().equalsIgnoreCase("password"))
                password=ck.getValue();
        }
        if(!username.isEmpty()&&!password.isEmpty())
            account=new Account(username,password);
        return account;
            
    }
    protected HttpServletResponse servletResponse;
    public void setServletResponse(HttpServletResponse servletResponse){
        this.servletResponse=servletResponse;
    }
    protected HttpServletRequest servletRequest;
    public void setServletRequest(HttpServletRequest servletRequest){
        this.servletRequest=servletRequest;
    }
}
