
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.restaurant.restaurant.entity.Food" %>
<%@ page import="com.restaurant.restaurant.entity.Category" %>
<%@ page import="com.restaurant.restaurant.entity.myenum.FoodStatus" %>

<%
    Food obj = (Food) request.getAttribute("obj");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null){
        categories = new ArrayList<>();
    }
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    String url = "/admin/food/create";
    if(action == 2){
        url = "/admin/food/edit";
    }
    if(errors == null){
        errors = new HashMap<>();
    }
%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/admin/includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="/admin/includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Food management</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/food/list">Food Management</a></li>
                            <li class="breadcrumb-item active"><%=request.getAttribute("breadcrumb")%></li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <%
                    if(errors != null && errors.size() > 0){
                %>
                <div class="row">
                    <div class="col-12">
                        <div class="callout callout-danger">
                            <h5>Please fix error below</h5>
                            <ul>
                                <%
                                    for (String msg: errors.values()){
                                %>
                                <li class="text-danger"><%=msg%></li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                    </div>
                </div>
                <%}%>
                <div class="row">
                    <div class="col-12">
                        <div class="card card-warning">
                            <div class="card-header">
                                <h3 class="card-title">Please enter information below</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <form action="<%=url%>" method="post" name="product-form">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input type="text" name="name" value="<%=obj.getName()%>" class="form-control" placeholder="Please enter food name">
                                                <%if(errors.containsKey("name")){%>
                                                <span class="text-danger">* <%=errors.get("name")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <!-- select -->
                                            <div class="form-group">
                                                <label for="categoryId">Please choose categories option</label>
                                                <select id="categoryId" name="categoryId" class="form-control">
                                                    <%if (action == 1){%>
                                                    <option value="0">Tất cả</option>
                                                    <%}%>
                                                    <%for (int i = 0; i < categories.size(); i++) {%>
                                                    <%if (obj.getCategoryId() == categories.get(i).getId()){%>
                                                    <option selected value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                                    <%}else{%>
                                                    <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                                    <%}}%>
                                                </select>
                                                <%if (errors.containsKey("categoryId")){%>
                                                <span class="text-danger">* <%=errors.get("categoryId")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input type="number" name="price" value="<%=obj.getPrice()%>" class="form-control" placeholder="Please enter price">
                                                <%if(errors.containsKey("price")){%>
                                                <span class="text-danger">* <%=errors.get("price")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Description</label>
                                                <input type="text" name="description" value="<%=obj.getDescription()%>" class="form-control" placeholder="Please enter description">
                                                <%if(errors.containsKey("description")){%>
                                                <span class="text-danger">* <%=errors.get("description")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Thumbnail</label>
                                                <div class="input-group">
                                                    <div class="custom-file">
                                                        <input type="text" name="thumbnail" value="<%=obj.getThumbnail()%>" class="form-control" placeholder="Please choose image">
                                                    </div>
                                                    <div class="input-group-append" id="upload_widget">
                                                        <span class="input-group-text">Upload</span>
                                                    </div>
                                                </div>
                                                <img id="preview-image" style="display: none" src="" alt="" class="img-bordered mt-2" width="200px">
                                                <%if(errors.containsKey("thumbnail")){%>
                                                <span class="text-danger">* <%=errors.get("thumbnail")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <!-- select -->
                                            <div class="form-group">
                                                <label>Please choose status option</label>
                                                <select name="status" class="form-control">
                                                    <%for (int i = 0; i < FoodStatus.values().length; i++) {%>
                                                    <option <%=obj.getStatus() == FoodStatus.values()[i] ? "selected" : ""%> value="<%=FoodStatus.values()[i].getValue()%>"><%=FoodStatus.values()[i].name()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <input type="submit" class="btn btn-primary" value="Save"/>
                                                <input type="reset" class="btn btn-default" value="Reset"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.card-body -->
                        </div>
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

    <jsp:include page="/admin/includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="/admin/includes/script.jsp"></jsp:include>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script>
    document.addEventListener('DOMContentLoaded', function (){
        $('#summernote').summernote()
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 'dpwixbzs0',
                uploadPreset: 'z0mo3jfl'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info.secure_url);
                    document.forms['product-form']['thumbnail'].value = result.info.secure_url;
                    document.getElementById('preview-image').src = result.info.secure_url;
                    document.getElementById('preview-image').style.display = "block";
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    })
</script>


</body>
</html>
