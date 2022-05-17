<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.t2010a.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/12/2022
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> listCustomer = (List<Customer>)request.getAttribute("listCustomer");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">DataTable with default features</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Customer ID</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Joined At</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for(Customer cus: listCustomer){
                                    %>
                                    <tr>
                                        <td><%=cus.getCusID()%></td>
                                        <td><%=cus.getName()%></td>
                                        <td><%=cus.getPhone()%></td>
                                        <td><%=cus.getJoinedAt()%></td>
                                        <td>
                                            <a href="/admin/customers/detail?id=<%=cus.getCusID()%>">Detail</a>&nbsp;&nbsp;
                                            <a href="/admin/customers/edit?id=<%=cus.getCusID()%>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/customers/delete?id=<%=cus.getCusID()%>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Customer ID</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Joined At</th>
                                        <th>Action</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

 <jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>
