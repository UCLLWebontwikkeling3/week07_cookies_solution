<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Tourism</title>
    <link rel="stylesheet" href="css/sample.css">
    <style>
        main{
            display: flex;
            height: 70vh;
            align-content: center;
            justify-content: space-between;
        }
        main>article {
            flex-basis: 45%;
        }
        main>article>form, main>article>form>input {
            width: 100%;
            height: 40vh;
            font-size: 1em;
        }
    </style>
</head>
<body>
<header role="banner">
    <img alt="Toscane" src="images/toscaneRibbon.jpg">
</header>
<main>
    <article>
        <form action="Servlet?action=lang" method="post">
            <input type="hidden" name="language" value="nl">
            <input type="submit" value="Beleef de leukste vakantie van je leven!">
        </form>
    </article>
    <article>
        <form action="Servlet?action=lang" method = "post">
            <input type="hidden" name="language" value="en">
            <input type="submit" value="Have a sweet holiday!">
        </form>
    </article>
</main>
</body>
</html>
