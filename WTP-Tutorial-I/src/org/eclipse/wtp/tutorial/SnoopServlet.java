package org.eclipse.wtp.tutorial;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SnoopServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("user-agent");
        String clientBrowser = "Not known!";
        if (userAgent != null) clientBrowser = userAgent;
        req.setAttribute("client.browser", clientBrowser);
        req.getRequestDispatcher("/showBrowser.jsp").forward(req, resp);
    }
}