<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.javaee.db.Footballer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Footballer added successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/add" method="post">
                <div class="form-group">
                    <label>
                        ID:
                    </label>
                    <input class="form-control" type="text" name="id">
                    <label>
                        NAME :
                    </label>
                    <input type="text" name="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        SURNAME :
                    </label>
                    <input type="text" name="surname" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        SALARY :
                    </label>
                    <input type="number" name="salary" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        CLUB :
                    </label>
                    <input type="text" name="club" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        TRANSFER PRICE :
                    </label>
                    <input type="number" name="transfer_price" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">
                        ADD FOOTBALLER
                    </button>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
