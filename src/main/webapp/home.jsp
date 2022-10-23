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
            <h4 class="mb-4">
                CONTENTS OF <%=siteName%>
            </h4>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>SALARY</th>
                    <th>CLUB</th>
                    <th>TRANSFER PRICE</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("footballer");
                    if(footballers!=null) {
                        for(Footballer it : footballers){
                    %>
                <tr>
                    <td>
                        <%=it.getId()%>
                    </td>
                    <td>
                        <%=it.getName()%>
                    </td>
                    <td>
                        <%=it.getSurname()%>
                    </td>
                    <td>
                        <%=it.getSalary()%>
                    </td>
                    <td>
                        <%=it.getClub()%>
                    </td>
                    <td>
                        <%=it.getTransferPrice()%>
                    </td>
                    <td>
                        <a href="/details?id=<%=it.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
                    </td>
                </tr>
                <%
                        }
                    }
                    %>
                </tbody>
            </table>

        </div>

    </div>
</div>
</body>
</html>
