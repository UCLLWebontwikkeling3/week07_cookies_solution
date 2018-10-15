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

        String destination = "";

        switch (action) {
            case "lang":
                destination = selectLanguage(request, response);
                break;
            default:
                destination = giveIndex(request, response);

        }


        request.getRequestDispatcher(destination).forward(request, response);

    }

    /**
     * Depending on the existence and/or value of the cookie with key "language"
     * the right index page is returned
     *
     * @return if a cookie with key "language" exists and has value "nl": "nl/index.jsp"
     * if a cookie with key "language" exists and has value "en": "en/index.jsp"
     * if no cookie with key "language" exists: "index.jsp"
     * if a cookie with key "language" exists but has value different from "nl" or "en": "index.jsp"
     */
    private String giveIndex(HttpServletRequest request, HttpServletResponse response) {
        String language = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("language")) {
                    String value = cookie.getValue();
                    if (value.equals("nl") || value.equals("en"))
                        language = cookie.getValue() + "/";
                }
            }
        }
        return language + "index.jsp";
    }

    /**
     * Sets a cookie depending on the chosen language
     * @return if the chosen language equals "nl": "nl/index.jsp"
     * if the chosen language equals "en": "en/index.jsp"
     */
    private String selectLanguage(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);
        return language + "/index.jsp";
    }

}
