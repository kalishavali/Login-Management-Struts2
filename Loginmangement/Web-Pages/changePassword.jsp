<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/Header_1.jsp"%>
<script type="text/javascript">
    $(document).ready(function()
    {
         $(document).on('submit', '#reg-form', function()
         {

          //var fn = $("#fname").val();
          //var ln = $("#lname").val();

          //var data = 'fname='+fn+'&lname='+ln;

          var data = $(this).serialize();


          $.ajax({

          type : 'POST',
          url  : 'changePassword',
          data : data,
          success :  function(data)
               {
              $('.ui.modal').modal('show');

               }
          });
          return false;
         });

    });
</script>
<!--ChangePassword-->
    <s:div cssClass="ui grey horizontal divider" id="center_login">
        ChangePassword
    </s:div>
    <s:if test="hasActionErrors()">
        <s:div cssClass="ui grey tall stacked center aligned segment" id="center_login">
            <s:actionerror/>
        </s:div>
	</s:if>
    <s:div cssClass="ui grey tall stacked segment" id="center_login">
        <form class="ui form"  method="post" id="reg-form" action="changePassword">
            <s:div cssClass="ui labeled input">
                <s:div cssClass="ui label">
                    New Password
                </s:div>
                <s:textfield type="text" placeholder="New Password" name="user.password"/>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:div cssClass="ui labeled input">
                <s:div cssClass="ui label">
                    Retype
                </s:div>
                <s:textfield type="text" placeholder="Retype Password" name="user.secPassword"/>
            </s:div>
            <s:div cssClass="ui hidden divider"/>
            <s:submit cssClass="fluid ui teal basic button" value="Submit"/>
            <s:div cssClass="ui error message"/>
        </form>
    </s:div>
<!-- Footer-->
<%@include file="includes/Footer.jsp"%>
