<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header.jsp"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String sessionCheck=(String)session.getAttribute("userName");
    if (sessionCheck!= null)
    {
        String address = "/welcome.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
%>

<!-- Login -->
    <s:div cssClass="ui grey horizontal divider" id="center_login">
        Login
    </s:div>
    <s:if test="hasActionErrors()">
        <s:div cssClass="ui grey tall stacked center aligned segment" id="center_login">
            <s:actionerror/>
        </s:div>
	</s:if>
    <s:div cssClass="ui grey tall stacked segment" id="center_login">
        <form class="ui grey form" action="Login" method="post">
            <s:div cssClass="ui grey labeled input">
                <s:div cssClass="ui grey label">
                    Username
                </s:div>
                <s:textfield type="text" placeholder="Username" name="user.userName"/>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:div cssClass="ui grey labeled input">
            	<s:textfield type="text" placeholder="Password" name="user.password"/>
                <s:div cssClass="ui grey label">
                    Password
                </s:div>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:div cssClass="ui grey slider checkbox">
                <s:checkbox name="user.remember" value="true"/>
                <label>Remember Me?</label>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:div cssClass="ui basic segment">
                <a href="forgotPassword" class="grey">Forgot Password?</a>
            </s:div>
            <s:submit cssClass="fluid ui grey basic button" value="Login"/>
            <s:div cssClass="ui error message" />
        </form>
    </s:div>
    <s:div cssClass="ui grey tall stacked center aligned segment" id="center_login">
        Not Registered? <a href="Register">Register</a> 
    </s:div>

<!-- Footer-->
<%@include file="includes/Footer.jsp"%>
