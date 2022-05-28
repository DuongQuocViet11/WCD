<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.restaurant.restaurant.entity.Food" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Food> list =  (List<Food>) request.getAttribute("list");
    if(list == null){
        list = new ArrayList<>();
    }
%>
<html>
<jsp:include page="/admin/includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/admin/includes/navbar.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="/admin/includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>List Food</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/food/list">Food</a></li>
                            <li class="breadcrumb-item active">List Food</li>
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
                                <h3 class="card-title">List Food</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Food ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Thumbnail</th>
                                        <th>Created At</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for(Food food: list){
                                    %>
                                    <tr>
                                        <td><%=food.getId()%></td>
                                        <td><%=food.getName()%></td>
                                        <td><%=food.getPrice()%></td>
                                        <td>
                                            <img class="img-bordered" src="<%=food.getThumbnail()%>" alt="" width="150px">
                                        </td>
                                        <td><%=food.getCreatedAt()%></td>
                                        <td>
                                            <a href="/admin/food/detail?id=<%=food.getId()%>">
                                                Detail
                                            </a>
                                            <a href="/admin/food/edit?id=<%=food.getId()%>">
                                                Edit
                                            </a>
                                            <a href="/admin/food/delete?id=<%=food.getId()%>" onclick="return confirm('Are you sure?')">
                                                Delete
                                            </a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Thumbnail</th>
                                        <th>Created At</th>
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
    <!--footer -->
    <jsp:include page="/admin/includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="/admin/includes/script.jsp"></jsp:include>
</body>
</html>

