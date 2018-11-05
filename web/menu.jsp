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
    <c:if test="${taal == 'NEDERLANDS'}">
        <p><a href="Controller?command=switchLanguage">EN</a></p>
    </c:if>
    <c:if test="${taal == 'ENGELS'}">
        <p><a href="Controller?command=switchLanguage">NL</a></p>
    </c:if>

</header>
<main>
    <h1>${taal}</h1>
    <article>
        <form action="Controller?command=login" method="post">
            <input type="hidden" name="language" value="nl">
            <input type="submit" value="Aanmelden">
        </form>
    </article>
</main>
</body>
</html>
