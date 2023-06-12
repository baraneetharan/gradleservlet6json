<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="shortcut icon" href="#">
    <script src="book.js"></script>
</head>

<body onload="getItems()">
    <h1>Books CRUD using XHR</h1>
    <form action="javascript:void(0);" method="POST">
        <input type="text" id="title" placeholder="title">
        <input type="text" id="author" placeholder="author">
        <input type="text" id="price" placeholder="price">
        <input type="text" id="qty" placeholder="qty">
        <button type="submit" id="myBtn" onclick="saveORupdateItem()">Save</button>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tbody id="books"></tbody>
    </table>
    </table>

    <!-- <script src="book.js" asp-append-version="true"></script>
    <script type="text/javascript">
        getItems();
    </script> -->
</body>

</html>