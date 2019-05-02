<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
This header could be included in all files in maps "en" and "nl".
The attributes "home" and "language" should be set properly according to the value of the cookie
sent with the request of according to the new chosen language.
E.g.
request.setAttribute("home",giveLanguage(request).equals("nl/")?"Thuis":"Home");
request.setAttribute("languageToSwitch",giveLanguage(request).equals("nl/")?"EN":"NL");
-->
<header><p><a href="Servlet">${home}</a></p>
    <p><a href="Servlet?action=switchLanguage">${languageToSwitch}</a></p>
    ${cookie['language']}
</header>