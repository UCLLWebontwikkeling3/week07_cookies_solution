package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        String destination;

        switch (action) {
            case "lang":
                destination = setLanguage(request, response);
                break;
            case "somethingMore":
                destination = giveLanguage(request) + "somethingMore.jsp";
                break;
            case "switchLanguage":
                destination = switchLanguage(request, response);
                break;
            default:
                destination = giveLanguage(request) + "index.jsp";

        }


        request.getRequestDispatcher(destination).forward(request, response);

    }

    /**
     * Switches the cookie from nl to en and vice versa
     *
     * @return the index page in the new language
     */
    private String switchLanguage(HttpServletRequest request, HttpServletResponse response) {
        String newLanguage ;
        String oldLanguage = giveLanguage(request);
        switch (oldLanguage) {
            case "nl/":
                newLanguage = "en/";
                break;
            case "en/":
                newLanguage = "nl/";
                break;
            default:
                newLanguage = "";
        }
//        Use this when you learned to forward a response
//        String s = request.getRequestURL().toString();
//        String action = s.substring(s.lastIndexOf("?action=")+1);

        Cookie cookie = new Cookie("language", newLanguage);
        response.addCookie(cookie);
        return newLanguage + "index.jsp";
    }

    /**
     * Reads the value of the cookie with key "language"
     */
    private String giveLanguage(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("language"))
                    return cookie.getValue();
        return "";
    }

    /**
     * Sets a cookie with key "language" depending on the chosen language
     *
     * @return the index page in the chosen language
     */
    private String setLanguage(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language") + "/";
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);

        return language + "index.jsp";
    }

}
