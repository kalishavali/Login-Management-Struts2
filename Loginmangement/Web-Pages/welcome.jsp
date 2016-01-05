<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header_1.html" %>
<script>
$(function(){
	 $('#first').on('click', function(e){
		 $('.ui.modal').modal('show');
		  })


	
	
});
//window Load Function
$(window).load(function () {
	$('.ui.modal').modal('show');

	});
</script>
<%
	String sessionCheck=(String)session.getAttribute("userName");
	if (sessionCheck==null)
	{
	  String address = "/index.jsp";
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	  dispatcher.forward(request,response);
	}
%>

<div class="ui segment">
<!-- Body Start-->
	<%if(sessionCheck!=null){ %>
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
	<%} %>
    <h4 class="ui teal horizontal divider header"><i class="tag icon"></i>Description</h4>
    <div class="ui teal message">
  		<div class="header">
    		New Site Features
  		</div>
  		<ul class="list">
    		<li>You can now have cover images on blog pages</li>
    		<li>Drafts will now auto-save while writing</li>
  		</ul>
	</div>
	<h4 class="ui teal horizontal divider header"> <i class="bar chart icon"></i>Specifications</h4>
	<table class="ui definition table">
  		<tbody>
		    <tr>
		      <td class="two wide column">Login</td>
		      <td>Created</td>
		    </tr>
		    <tr>
		      <td>Signup</td>
		      <td>Created</td>
		    </tr>
		    <tr>
		      <td>ForgotPassword</td>
		      <td></td>
		    </tr>
		    <tr>
		      <td>ChangePassword</td>
		      <td></td>
		    </tr>
		 </tbody>
	</table>
  
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
