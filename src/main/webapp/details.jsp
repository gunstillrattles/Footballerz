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
        <div class="col-sm-12">
            <%
                Footballer footballer = (Footballer)request.getAttribute("footballer");
                if(footballer!=null){
            %>
            <div class="jumbotron">
                <h1 class="display-4">
                    <%=footballer.getName()%>
                </h1>
                <h1 class="display-4">
                    <%=footballer.getSurname()%>
                </h1>
                <h1 class="display-4">
                    <%=footballer.getClub()%>
                </h1>
                <p class="lead">
                   PRICE : <%=footballer.getSalary()%> USD
                </p>
                <hr class="my-4">
                <p>
                    TRANSFER PRICE : <%=footballer.getTransferPrice()%> USD
                </p>
                <a class="btn btn-primary btn-sm" href="/edit?id=<%=footballer.getId()%>" role="button">EDIT</a>
            </div>
            <%
                }
            %>
        </div>

    </div>
</div>
</body>
</html>