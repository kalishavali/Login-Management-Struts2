<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header_1.html" %>

<div class="ui segment">
<!-- Body Start-->

    <div class="ui horizontal divider" id="center_login">Success</div>
    <div class="ui tall stacked segment" id="center_login">
        <div class="ui segment">
            You Successfully Changed Your Password<br>
            <a href="<s:property value="forgotDetails[0]"/>"><s:property value="forgotDetails[0]"/></a>
        </div>
    </div>
  
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>
