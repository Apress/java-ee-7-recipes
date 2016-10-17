package org.javaeerecipes.chapter01.recipe01_18;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsyncServlet", urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
@WebFilter(urlPatterns="/*", asyncSupported=true)
public class AsyncServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("Starting doGet");
            AsyncContext ac = request.startAsync();
            ac.addListener(new MyListener());
            System.out.println("Do some stuff in doGet ...");
// Start another service
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
            executor.execute(new ServletService(ac));
            System.out.println("Some more stuff in doGet ...");
        } finally {
        }
    }
}
