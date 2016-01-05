<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header_1.html"%>
<%
	String sessionCheck=(String)session.getAttribute("userName");
	if (sessionCheck==null)
	{
	  String address = "/index.jsp";
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	  dispatcher.forward(request,response);
	}
%>
<script>
$(function() {
	$("#submit").click(function() {
	var name = $("#changePassword").val();
	var username = $("#changePassword1").val();
	var dataString = 'name='+ name + '&username=' + username + '&password=' + password + '&gender=' + gender;

	if(name=='' || username=='' || password=='' || gender=='')
	{
	$('.success').fadeOut(200).hide();
	$('.error').fadeOut(200).show();
	}
	else
	{
	$.ajax({
	type: "POST",
	url: "#",
	data: dataString,
	success: function(){
		$('.ui.modal').modal('show');
	}
	});
	}
	return false;
	});
	});
</script>
<div class="ui grey segment">
<!-- Body Start-->
        <div class="ui horizontal divider" id="center_login">Change Password</div>
        <div class="ui tall stacked center aligned segment" id="center_login"></div>
        <div class="ui grey tall stacked segment" id="center_login">
            <form class="ui form"  method="post">
                <div class="ui labeled input">
                    <div class="ui label">
                        New Password
                    </div>
                    <input type="text" placeholder="New Password" name="changePassword" id="pass1">
                </div>
                <div class="ui hidden divider"></div>
                <div class="ui labeled input">
                    <div class="ui label">
                        Retype
                    </div>
                    <input type="text" placeholder="Retype Password" name="changePassword1"  id="pass2">
                     <span id="confirmMessage" class="confirmMessage"></span>
                </div>
                <div class="ui hidden divider"></div>
                <button class="fluid ui teal basic button" type="submit" id="submit">Submit</button>
                <div class="ui error message"></div>
            </form>
        </div>
        <div class="ui modal">
  		<div class="header">Login Management</div>
		<div class="content">
		   	<p>Hello,    <%=sessionCheck%></p>
		   	<p>Welcome to Login Management System of Our Website</p>
		   	<p>For your Portfolio and Actions Plese Go...</p>
		 	</div>
		  	<div class="actions">
		    	<div class="ui approve button">Go</div>
      </div>
		  	</div>
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>

