<!DOCTYPE html>
<html lang="en">
<body>
<h1> Users list </h1>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
    <#--        users - Это атрибут который придёт с модели -->
    <#list users as user>
        <tr>
            <td> ${user.id} </td>
            <td> ${user.name} </td>
            <td> ${user.email} </td>
            <td> ${user.age} </td>
        </tr>
    </#list>
</table>

</body>


<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
</html>