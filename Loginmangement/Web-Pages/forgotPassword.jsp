<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header.jsp" %>


<!-- ForgotPassword -->
    <s:div cssClass="ui grey horizontal divider" id="center_login">
        ChangePassword
    </s:div>
    <s:if test="hasActionErrors()">
        <s:div cssClass="ui grey tall stacked center aligned segment" id="center_login">
            <s:actionerror/>
        </s:div>
	</s:if>
    <s:div cssClass="ui grey tall stacked segment" id="center_login">
        <form class="ui grey form" action="forgotPassword" method="post">
            <s:div cssClass="ui labeled input">
                <s:div cssClass="ui label">
                    Email
                </s:div>
                <s:textfield placeholder="Enter Your Mail" name="user.email"/>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:submit cssClass="fluid ui teal basic button" value="Submit"/>
            <s:div cssClass="ui error message"/>
        </form>
    </s:div>
<!-- Footer-->
<%@include file="includes/Footer.jsp"%>
