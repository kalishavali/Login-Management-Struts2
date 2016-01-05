<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/Header.html" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="ui segment">
<!-- Body Start-->
    <div class="ui horizontal divider" id="register_center">register</div>
    <s:if test="hasActionErrors()">
    	<div class="ui teal tall stacked center aligned segment" id="center_login">
        	<s:actionerror/>
    	</div>
	</s:if>
        <form class="ui tall stacked form segment" id="register_center" action="register" method="post" >
            <p>Tell Us About Yourself</p>
            <div class="two fields">
                <div class="field">
                    <label>Name</label>
                    <input placeholder="First Name" name="name" type="text">
                </div>
                <div class="field">
                    <label>Gender</label>
                    <select class="ui dropdown" name="gender">
                      <option value="">Gender</option>
                      <option value="male">Male</option>
                      <option value="female">Female</option>
                    </select>
                </div>
            </div>
            <div class="two fields">
                <div class="field">
                  <label>Username</label>
                  <input placeholder="Username" name="userName" type="text">
                </div>
                <div class="field">
                  <label>Password</label>
                  <input type="password" name="password">
                </div>
            </div>
            <div class="two fields">
                <div class="field">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Email">
                </div>
            </div>
            <div class="inline field">
                <div class="ui checkbox">
                  <input type="checkbox" name="terms">
                  <label>I agree to the terms and conditions</label>
                </div>
            </div>
            <button class="fluid ui teal basic button" type="submit">Submit</button>
            <div class="ui error message"></div>
        </form>
<div class="ui horizontal divider" id="register_center">or</div>
<div class="ui tall stacked center aligned segment" id="register_center">
    Already Registered? <a href="login">Login</a>
</div>

<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
