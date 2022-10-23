<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.javaee.db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User added successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/register" method="post">
                <div class="form-group">
                    <label>
                        LOGIN :
                    </label>
                    <input type="text" name="login" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        PASSWORD :
                    </label>
                    <input type="text" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">
                        ADD USER
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>