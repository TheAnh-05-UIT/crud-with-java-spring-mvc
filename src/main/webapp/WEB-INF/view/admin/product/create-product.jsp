<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const imageFile = $("#imageFile");
                        imageFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#imagePreview").attr("src", imgURL);
                            $("#imagePreview").css({ "display": "block" });
                        });
                    });
                </script>
                <title>Create Product</title>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Create a product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active">
                                        <a href="/admin">Dashboard</a>
                                        <span>/</span>
                                        <a href="/admin/product">Products</a>
                                        <span> / Create product</span>
                                    </li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="row g-3">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create a product</h3>
                                            <hr>
                                            <form:form class="row" method="POST" action="/admin/product/create"
                                                modelAttribute="newProduct" enctype="multipart/form-data">
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Name</label>
                                                    <form:input type="text" class="form-control" path="name"
                                                        placeholder="Name Product" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Price</label>
                                                    <form:input type="number" class="form-control" path="price"
                                                        placeholder="0.0" />
                                                </div>
                                                <div class="mb-3 col-12">
                                                    <label class="form-label">Detail description</label>
                                                    <form:textarea class="form-control" rows="3" path="detailDesc" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Short description</label>
                                                    <form:input type="text" class="form-control" path="shortDesc"
                                                        placeholder="Short description" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Quantity</label>
                                                    <form:input type="number" class="form-control" path="quantity"
                                                        placeholder="Quantity" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Factory</label>
                                                    <form:select class="form-select" path="factory">
                                                        <option selected>Choose factory</option>
                                                        <form:option value="ADMIN">ADMIN</form:option>
                                                        <form:option value="USER">USER</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Target</label>
                                                    <form:select class="form-select" path="target">
                                                        <option selected>Choose target</option>
                                                        <form:option value="ADMIN">ADMIN</form:option>
                                                        <form:option value="USER">USER</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label" for="imageFile">Image</label>
                                                    <input class="form-control" type="file" id="imageFile"
                                                        accept=".png, .jpg, .jpeg" name="imageFile" />
                                                </div>
                                                <div>
                                                    <img style="max-height: 250px; max-width: 600px; display: none;"
                                                        alt="image" id="imagePreview">
                                                </div>
                                                <div class="d-flex justify-content-between">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                    <a href="/admin/product" class="btn btn-success"
                                                        type="button">Back</a>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>

            </html>