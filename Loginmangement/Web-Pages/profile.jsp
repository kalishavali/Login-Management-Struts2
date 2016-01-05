<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@include file="includes/Header_1.html"%>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%	
	ArrayList detailCheck=(ArrayList)request.getAttribute("details");
	request.setAttribute("detailCheck",detailCheck);
	String sessionCheck=(String)session.getAttribute("userName");
	if (sessionCheck==null)
	{
	  String address = "/index.jsp";
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	  dispatcher.forward(request,response);
	}
%>

<div class="ui teal segment">
<!-- Body Start-->
    <div class="ui teal horizontal segments">
        <div class="ui teal card">
            <div class="image">
                <img src="${pageContext.request.contextPath}/images/avatar2/large/elliot.jpg">
            </div>
            <div class="content">
                <div class="header"><s:property value="details[8]"/></div>
                <div class="meta">
                  <span class="date"><s:property value="details[5]"/></span>
                </div>
                <div class="description">
                  Kali is a personal assistant living in Hyderabad.
                </div>
            </div>
            <div class="extra content">
                <span class="right floated">
                    Joined in 2013
                </span>
                <span>
                    <i class="user icon"></i>
                    75 Friends
                </span>
            </div>
        </div>
        <div class="ui teal segment" id="account_right">
            <h4 class="ui horizontal divider header"><i class="tag icon"></i>About</h4>
            <p><s:property value="details[1]"/></p>
            <h4 class="ui horizontal divider header"><i class="bar chart icon"></i>Account Details</h4>
            <table class="ui teal definition table">
              <tbody>
                <tr>
                    <td class="two wide column"><i class="mail icon"></i>Email</td>
                  <td><s:property value="details[6]"/></td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="male icon"></i>Gender</td>
                  <td><s:property value="details[9]"/></td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="birthday icon"></i>Date of Birth</td>
                  <td><s:property value="details[2]"/></td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="call icon"></i>Phone</td>
                  <td><s:property value="details[3]"/></td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="map icon"></i>Address</td>
                  <td><s:property value="details[4]"/></td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="spy icon"></i>Designation</td>
                  <td><s:property value="details[5]"/></td>
                </tr>
              </tbody>
            </table>
            <a class="ui right floated button" href="editProfile">Edit</a>
        </div>
    </div>   
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
