<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User Page</title>
</head>
<body>
<h1> Create User Page </h1>

<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${user.id}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Email</p>
    <input title="Email" type="text" name="Email" value="${user.email}">
    <p>Age</p>
    <input title="Age" type="text" name="age" value="${user.age}">

    <input type="submit" value="OK">
</form>

</body>
</html>