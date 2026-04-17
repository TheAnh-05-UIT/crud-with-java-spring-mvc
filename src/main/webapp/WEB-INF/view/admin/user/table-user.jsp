<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <a%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <a%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <title>Table User</title>
                </head>

                <body>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <div class="d-flex justify-content-between">
                                    <h3>Table user</h3>
                                    <a href="/admin/user/create" type="button" class="btn btn-primary">
                                        Create a user
                                    </a>
                                </div>
                                <hr>
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Full Name</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="u" items="${users}">
                                            <tr>
                                                <th scope="row">${u.id}</th>
                                                <td>${u.email}</td>
                                                <td>${u.fullName}</td>
                                                <td>
                                                    <a href="/admin/user/${u.id}" type="button"
                                                        class="btn btn-success">View</a>
                                                    <a href="/admin/user/update/${u.id}" type="button"
                                                        class="btn btn-danger mx-2">Update</a>
                                                    <a href="/admin/user/delete/${u.id}" type="button"
                                                        class="btn btn-warning">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </body>

                </html>