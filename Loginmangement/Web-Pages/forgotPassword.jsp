<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header.html" %>

<div class="ui segment">
<!-- Body Start-->

    <div class="ui horizontal divider" id="center_login">Forgot Password</div>
    <s:if test="hasActionErrors()">
    	<div class="ui tall stacked center aligned segment" id="center_login">
        	<s:actionerror/>
    	</div>
	</s:if>
    <div class="ui tall stacked segment" id="center_login">
        <form class="ui form" action="forgotPassword" method="post">
            <div class="ui labeled input">
                <div class="ui label">
                    Email
                </div>
                <input type="text" placeholder="Email" name="email">
            </div>
            <div class="ui hidden divider"></div>
            <button class="fluid ui blue button">Submit</button>
            <div class="ui error message"></div>
        </form>
    </div>
  
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
