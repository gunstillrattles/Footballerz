<%@ page import="kz.javaee.db.Footballer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/add" method="post">
    <label>
        Name :
    </label>
    <input type="text" name="footballer_name">
    <label>
        Surname :
    </label>
    <input type="text" name="footballer_surname">
    <label>
        Salary :
    </label>
    <input type="text" name="footballer_salary">
    <label>
        Club :
    </label>
    <input type="text" name="footballer_club">
    <label>
        TransferPrice :
    </label>
    <input type="text" name="footballer_transferPrice">
    <button>ADD FOOTBALLER</button>
</form>

<form action="/delete" method="post">
    <label>
        ID :
    </label>
    <input type="text" name="footballer_id">
    <button>DELETE FOOTBALLER</button>
</form>
</body>
</html>