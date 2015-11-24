<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

${errorMessage}
<s:form action="login" method="post">
    <s:textfield label="username" name="account.username"></s:textfield>
    <s:password label="password" name="account.password"></s:password>
    <s:checkbox laebl="Remember Me?" name="remember" value="Remember Me?"></s:checkbox>
    <s:submit value="Login" align="left"></s:submit>
</s:form>
