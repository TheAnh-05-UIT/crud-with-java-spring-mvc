<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <!-- Latest compiled and minified CSS -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                        rel="stylesheet">
                    <!-- Latest compiled JavaScript -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                    <title>View User</title>
                </head>

                <body>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <div class="d-flex justify-content-between">
                                    <h3>Information user</h3>
                                </div>
                                <hr width="60%">
                                <div class="card" style="width: 60%" items="${userById}" var="user">
                                    <div class="card-header">
                                        User Information
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">ID: ${userById.id}</li>
                                        <li class="list-group-item">Email: ${userById.email}</li>
                                        <li class="list-group-item">Password: ${userById.password}</li>
                                        <li class="list-group-item">Full Name: ${userById.fullName}</li>
                                        <li class="list-group-item">Address: ${userById.address}</li>
                                        <li class="list-group-item">Phone: ${userById.phone}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </body>

                </html>