<!DOCTYPE html>
<html>
<head>
    <style>
        .main {
            font-weight: bold;
            font-size: xx-large;
            background-color: tomato;
        }
        .table {
            color: blue;
            background-color: yellow;
        }
    </style>
    <title>Countries</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>List of Countries</h2>
<div class="main">
    <a href="/">Back</a>
    &nbsp; <a href="/countries">Show countries</a>
    &nbsp; <a href="/add-country">Add country</a>
</div>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Language</th>
        <th>Actions</th>
    </tr>
    <#list countries as country>
        <tr>
            <td>${country.id}</td>
            <td>${country.name}</td>
            <td>${country.language}</td>
            <td>
                <a href="/edit-country/${country.id}">Edit</a>
                <form action="/delete-country/${country.id}" method="post" style="display:inline">
                    <input type="submit" value="Delete" onclick="return confirm('Delete this country?')"/>
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
