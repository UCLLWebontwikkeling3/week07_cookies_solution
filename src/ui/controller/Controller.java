package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "";
        }
        String destination = "menu.jsp";
        switch (command) {
            case "login":
                destination = login(request, response);
                break;
            case "switchLanguage" :
                destination = switchLanguage(request, response);
                break;
            default:
                destination = home(request, response);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        String currentLanguage = getCurrentLanguage(request);
        if (currentLanguage.equals("en")) {
            request.setAttribute("taal", "ENGELS");
        }
        else {
            request.setAttribute("taal", "NEDERLANDS");
        }
        return "menu.jsp";
    }

    private String switchLanguage(HttpServletRequest request, HttpServletResponse response) {
        String currentLanguage = getCurrentLanguage(request);

        String newLanguage = "nl";
        if (currentLanguage.equals("nl")) {
            newLanguage = "en";
        }
        Cookie cookie = new Cookie("language", newLanguage);
        response.addCookie(cookie);

        if (currentLanguage.equals("en")) {
            return "welkom.jsp";
        }
        else {
            return "welcome.jsp";
        }
    }

    private String getCurrentLanguage(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("language"))
                    return cookie.getValue();
        return "nl";
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        String selectedLanguage = request.getParameter("language");
        Cookie cookie = new Cookie("language", selectedLanguage);
        response.addCookie(cookie);
        return "welkom.jsp";
    }

}
