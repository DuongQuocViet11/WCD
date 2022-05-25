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
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="/admin/register"><b>Admin</b>Aptech</a>
    </div>

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
        <div class="card-body register-card-body">
            <p class="login-box-msg">Register a new membership</p>

            <form action="/admin/register" method="post">
                <div class="input-group mb-3">
                    <input type="text" name="username" class="form-control" placeholder="User name" value="<%=account.getUsername()%>">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="email" name="email" class="form-control" placeholder="Email" value="<%=account.getEmail()%>">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
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
                <div class="input-group mb-3">
                    <input type="password" name="confirmPassword" class="form-control" placeholder="Retype password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" name="phone" class="form-control" placeholder="Phone">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-phone"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>



            <a href="/admin/login" class="text-center">I already have a membership</a>
        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>


