<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>
<%@include file="includes/Header_1.jsp"%>

<div class="ui segment">
<!-- Body Start-->
<h4 class="ui teal horizontal divider header"><i class="edit icon"></i>Edit Profile</h4>
<form class="ui form" action="editProfile" method="post">
  	<table class="ui teal definition table">
              <tbody>
                <tr>
                    <td class="two wide column"><i class="mail icon"></i>Email</td>
                  <td><input name="email" value="<s:property value="details[6]"/>"/> </td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="male icon"></i>Gender</td>
                  <td><input name="gender" value="<s:property value="details[9]"/>"/> </td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="birthday icon"></i>Date of Birth</td>
                  <td><input name="dateOfBirth" value="<s:property value="details[2]"/>"/> </td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="call icon"></i>Phone</td>
                  <td><input name="phone" value="<s:property value="details[3]"/>"/> </td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="map icon"></i>Address</td>
                  <td><input name="address" value="<s:property value="details[4]"/>"/> </td>
                </tr>
                <tr>
                    <td class="two wide column"><i class="spy icon"></i>Designation</td>
                  <td><input name="designation" value="<s:property value="details[5]"/>"/> </td>
                </tr>
              </tbody>
	</table>
	<button class="ui teal basic right floated button" type="submit">Save</button>
</form>
            
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.jsp"%>
