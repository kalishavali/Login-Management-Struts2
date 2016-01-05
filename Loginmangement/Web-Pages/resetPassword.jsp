<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header.html"%>
<script>
jQuery(function(){
    $("#submit").click(function(){
    $(".error").hide();
    var hasError = false;
    var passwordVal = $("#pass1").val();
    var checkVal = $("#pass2").val();
    if (passwordVal == '') {
        $(".aligned").append('<span class="error">Please enter a password.</span>');
        hasError = true;
    } else if (checkVal == '') {
        $(".aligned").append('<span class="error">Please re-enter your password.</span>');
        hasError = true;
    } else if (passwordVal != checkVal ) {
        $(".aligned").append('<span class="error">Passwords do not match.</span>');
        hasError = true;
    }
    if(hasError == true) {return false;}
});
});
</script>
<div class="ui segment">
<!-- Body Start-->
        <div class="ui horizontal divider" id="center_login">Change Password</div>
        <div class="ui tall stacked center aligned segment" id="center_login"></div>
        <div class="ui tall stacked segment" id="center_login">
            <form class="ui form" action="resetPassword" method="post" >
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
                    <input type="text" placeholder="Retype Password" name="changePassword1" id="pass2">
                </div>
                <div class="ui hidden divider"></div>
                <input type="hidden" name="token" value="<%=request.getParameter("token") %>"/>
                
                <button class="fluid ui blue button" type="submit" id="submit">Submit</button>
            </form>
        </div>
<!-- Body End-->
</div>
<!-- Footer-->
<%@include file="includes/Footer.html"%>

