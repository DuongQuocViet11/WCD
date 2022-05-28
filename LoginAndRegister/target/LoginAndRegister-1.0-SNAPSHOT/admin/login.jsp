<%@ page import="com.example.loginandregister.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
    if(account == null){
        account = new Account();
    }
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="includes/head.jsp"></jsp:include>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="/admin/login"><b>Admin</b>Aptech</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <%
            if(account.getListErrors().size() > 0){
        %>
        <div class="row">
            <div class="col-12">
                <div class="callout callout-danger">
                    <h5>Please fix error below</h5>
                    <ul>
                        <%
                            for (int i =0; i < account.getListErrors().size(); i++){
                        %>
                        <li class="text-danger"><%=account.getListErrors().get(i)%></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>
        <%}%>
        <div class="card-body login-card-body">
            <p class="login-box-msg">Sign in to start your session</p>

            <form action="/admin/login" method="post">
                <div class="input-group mb-3">
                    <input type="text" name="username" class="form-control" placeholder="Username">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" name="password" class="form-control" placeholder="Password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Sign In</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <p class="mb-0">
                <a href="/admin/register" class="text-center">Register a new admin</a>
            </p>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>

