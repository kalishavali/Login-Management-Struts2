package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import Model.*;
import entities.*;

public class AccountController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        if(action==null){
            Account account=checkCookie(request);
            if(account==null)
                request.getRequestDispatcher("login.jsp").forward(request, response);
            else{
                AccountModel accModel=new AccountModel();
                if(accModel.login(account.getUsername(),account.getPassword())){
                    session.setAttribute("username",account.getUsername());
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }else{
                    session.setAttribute("error","Account's Invalid");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        }else{
            if(action.equalsIgnoreCase("logout")){
                //Remove Session
                session.removeAttribute("username");
                //Remove Cookie
                Cookie []cookies=request.getCookies();
                for(Cookie ck:cookies){
                    if(ck.getName().equalsIgnoreCase("username")){
                        ck.setMaxAge(0);
                        response.addCookie(ck);
                    }
                    if(ck.getName().equalsIgnoreCase("password")){
                        ck.setMaxAge(0);
                        response.addCookie(ck);
                    }
                }
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
    private Account checkCookie(HttpServletRequest request){
            Cookie[] cookies=request.getCookies();
            Account account=null;
            if(cookies==null)
                return null;
            else{
                String username="",password="";
                for(Cookie ck:cookies){
                    if(ck.getName().equalsIgnoreCase("username"))
                        username=ck.getValue();
                    if(ck.getName().equalsIgnoreCase("password"))
                        password=ck.getValue();
                }
                if(!username.isEmpty()&&!password.isEmpty())
                    account=new Account(username,password);
            }
            return account;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        AccountModel accModel=new AccountModel();
        if(action==null){
            String username=request.getParameter("username").trim();
            String password=request.getParameter("password").trim();
            boolean remember=request.getParameter("remember")!=null;
            if(accModel.login(username,password)){
                session.setAttribute("username",username);
                if(remember){
                    Cookie ckUsername=new Cookie("username",username);
                    ckUsername.setMaxAge(3600);
                    response.addCookie(ckUsername);
                    Cookie ckPassword=new Cookie("password",password);
                    ckPassword.setMaxAge(3600);
                    response.addCookie(ckPassword);
                }
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }else{
                session.setAttribute("error","Account's Invalid");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else{
        
        }
    }
    

}
