<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Tourism</title>
    <link rel="stylesheet" href="../css/sample.css">
</head>
<body>
<header>
</header>
<main>
    <h1>Uw huidige taalkeuze is ${taal}</h1>
    <article>
        <form action="Controller?command=setLanguage" method="post">
            <input type="hidden" name="language" value="nl">
            <input type="submit" value="NL">
        </form>
        <form action="Controller?command=setLanguage" method="post">
            <input type="hidden" name="language" value="en">
            <input type="submit" value="EN">
        </form>
    </article>
</main>
</body>
</html>
