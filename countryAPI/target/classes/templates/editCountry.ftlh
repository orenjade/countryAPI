<!DOCTYPE html>
<html>
<head>
    <style>
        .main {
            font-weight: bold;
            font-size: xx-large;
            background-color: tomato;
        }
    </style>
    <title>Edit Country</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>Edit Country</h2>
<div class="main">
    <a href="/">Back</a>
    &nbsp; <a href="/countries">Show countries</a>
    &nbsp; <a href="/add-country">Add country</a>
</div>
<form action="/edit-country" method="post">
    <input type="hidden" name="id" value="${country.id}"/>
    <label for="name">Country name:</label><br>
    <input type="text" id="name" name="name" value="${country.name}"><br>
    <label for="language">Country Language:</label><br>
    <input type="text" id="language" name="language" value="${country.language}"><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
