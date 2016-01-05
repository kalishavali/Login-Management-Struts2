<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header.html"%>
<script>


</script>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<%
	String sessionCheck=(String)session.getAttribute("userName");
	if (sessionCheck!= null)
	{
	  String address = "/welcome.jsp";
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	  dispatcher.forward(request,response);
	}
%>

<div class="ui teal segment">
<!-- Body Start-->
    <div class="ui teal horizontal divider" id="center_login">Login</div>
    <s:if test="hasActionErrors()">
    	<div class="ui teal tall stacked center aligned segment" id="center_login">
        	<p><s:actionerror/></p>
    	</div>
	</s:if>
    <div class="ui teal tall stacked segment" id="center_login">
        <form class="ui teal form" action="login" method="post">
            <div class="ui teal labeled input">
                <div class="ui teal label">
                    Username
                </div>
                <input type="text" placeholder="Username" name="userName">
            </div>
            <div class="ui hidden divider"></div>
            <div class="ui teal right labeled input">
                <input type="text" placeholder="Password" name="password">
                <div class="ui teal label">
                    Password
                </div>
            </div>
            <div class="ui hidden divider"></div>
            <div class="ui teal slider checkbox">
                <input type="checkbox" name="remember" value="true">
                <label>Remember Me?</label>
            </div>
            <div class="ui hidden divider"></div>
            <div class="ui basic segment">
                <a href="forgotPassword" class="teal">Forgot Password?</a>
            </div>
            <button class="fluid ui teal basic button" type="submit">Submit</button>
            <div class="ui error message"></div>
        </form>
    </div>
    <div class="ui teal tall stacked center aligned segment" id="center_login">
        Not Registered? <a href="register">Register</a>
    </div>
    
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
