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
                <title>Update User</title>
            </head>

            <body>

                <body class="sb-nav-fixed">
                    <jsp:include page="../layout/header.jsp" />
                    <div id="layoutSidenav">
                        <jsp:include page="../layout/sidebar.jsp" />
                        <div id="layoutSidenav_content">
                            <main>
                                <div class="container-fluid px-4">
                                    <h1 class="mt-4">Update user</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active">
                                            <a href="/admin">Dashboard</a>
                                            <span>/</span>
                                            <a href="/admin/user">Users</a>
                                            <span>/ Update user</span>
                                        </li>
                                    </ol>
                                    <div class="container mt-5">
                                        <div class="row">
                                            <div class="col-md-6 col-12 mx-auto">
                                                <h3>Update a user</h3>
                                                <hr>
                                                <form:form method="POST" action="/admin/user/update"
                                                    modelAttribute="updateUser">
                                                    <div class="mb-3">
                                                        <label class="form-label">ID</label>
                                                        <form:input type="text" class="form-control bg-light text-muted"
                                                            value="${updateUser.id}" path="id" readonly="true"
                                                            style="cursor:default; pointer-events:none;" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Email</label>
                                                        <form:input type="email"
                                                            class="form-control bg-light text-muted" path="email"
                                                            value="${updateUser.email}" readonly="true"
                                                            style="cursor:default; pointer-events:none;" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Phone Number</label>
                                                        <form:input type="text" class="form-control" path="phone"
                                                            value="${updateUser.phone}" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Full Name</label>
                                                        <form:input type="text" class="form-control" path="fullName"
                                                            value="${updateUser.fullName}" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Address</label>
                                                        <form:input type="text" class="form-control" path="address"
                                                            value="${updateUser.address}" />
                                                    </div>
                                                    <div class="d-flex justify-content-between">
                                                        <button type="submit" class="btn btn-primary">Update</button>
                                                        <a type="button" href="/admin/user"
                                                            class="btn btn-success">Back</a>
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
            </body>

            </html>