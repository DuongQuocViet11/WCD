
<%@ page import="java.util.HashMap" %>

<%@ page import="java.util.List" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.exampaper.entity.Phone" %>
<%@ page import="com.example.exampaper.entity.Brand" %>


Created by IntelliJ IDEA.
  User: Admin
  Date: 5/12/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Phone phone = (Phone) request.getAttribute("phone");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
    if (brands == null){
        brands = new ArrayList<>();
    }
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors") ;
    String url = "/admin/phones/create";
    String title = "Create Phone";
    if(action == 2){
        title="Edit Phone";
        url = "/admin/phones/edit";
    }
    if (errors == null){
        errors = new HashMap<>();
    }

%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="<%=title%>"/>
</jsp:include>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="/admin/includes/navbar.jsp"></jsp:include>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper"
    >
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="/admin/includes/sidebar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <%
                    if(errors != null && errors.size() > 0){
                %>
                <div class="row">
                    <div class="col-12">
                        <div class="callout callout-danger">
                            <p class="text-danger fs-6">Please fix error below</p>
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
                <div class="page-header">
                    <h3 class="page-title"> Phone Management </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Phone management</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><%=title%></li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="card-title"><%=title%></h3>


                                <form class="forms-sample" action="<%=url%>" method="post" name="product-form">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="<%=phone.getId()%>" class="form-control" placeholder="Enter phone id">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Product Name</label>

                                                <input type="text" name="name" value="<%=phone.getName()%>" class="form-control" placeholder="Enter phone name">
                                                <%
                                                    if (errors.containsKey("name")){%>
                                                <span class="text-danger">* <%=errors.get("name")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Select Brand</label>
                                                <select name="brandId" class="form-control">
                                                    <option value="0">All</option>
                                                    <%
                                                        for (int i = 0; i < brands.size(); i++) {
                                                    %>
                                                    <option value="<%=brands.get(i).getId()%>"><%=brands.get(i).getName()%></option>
                                                    <%
                                                        }
                                                    %>

                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Price</label>

                                                <input type="text" name="price" value="<%=phone.getPrice()%>"  class="form-control" placeholder="Enter phone price">
                                                <%
                                                    if (errors.containsKey("price")){%>
                                                <span class="text-danger">* <%=errors.get("price")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Description</label>

                                                <input type="text" name="description" value="<%=phone.getDescription()%>"  class="form-control" placeholder="Enter phone description">
                                                <%
                                                    if (errors.containsKey("description")){%>
                                                <span class="text-danger">* <%=errors.get("description")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary me-2">Submit</button>
                                    <button type="Reset" class="btn btn-default">Reset</button>
                                    <a href="/admin/phones/list" class="btn btn-light">Cancel</a>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="/admin/includes/footer.jsp"></jsp:include>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<jsp:include page="/admin/includes/scripts.jsp"></jsp:include>

<script src="../ckeditor/ckeditor.js"></script>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>


<script type="text/javascript">
</script>
</body>
</html>