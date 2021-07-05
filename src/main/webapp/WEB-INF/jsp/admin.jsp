<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users Page</title>
</head>
<body>
    <p>${list}</p>
    <form id="new_user" action="/add" method="post" modelAtribute="newUser">
        <labeL>Name: <input name="name" type="text"></labeL>
        <labeL>Surname: <input name="surname" type="text"></labeL>
        <input type="submit" value="Add user">
    </form>
    <br>
    <br>
    <p id="gems">${gems}</p>
    <form id="get_gems" action="/getGems" method="post" modelAtribute="getGems">
        <label>Id: <input name="id" type="number"></label>
        <input type="submit" value="show gems">
    </form>
</body>
<style>
    body{ margin: 20px;}

    #new_user input[type="text"], input[type="number"]{
        display: block;
        font-size:18px;
        padding:4px 2px;
        border:solid 1px #aacfe4;
        width:150px;
        margin:2px 0 20px 0;
    }
    #get_gems input[type="number"]{
        display: block;
        font-size:18px;
        padding:4px 2px;
        border:solid 1px #aacfe4;
        width:150px;
        margin:2px 0 20px 0;
    }
</style>
<script>
    let url_string = window.location.href;
    let url = new URL(url_string);
    let c = "Gems: " + url.searchParams.get("gems");
    if (c === "Gems: -1"){
        c = "No user with the id found";
    }
    let element = document.getElementById("gems");
    element.innerHTML = c;
</script>
</html>