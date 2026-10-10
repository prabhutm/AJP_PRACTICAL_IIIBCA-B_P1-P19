package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initial")
public class InitialServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
String action = request.getParameter("action");
if ("redirect".equals(action)) {
response.sendRedirect("target?action=redirected");
} else {
request.getRequestDispatcher("target").forward(request, response);
}
}
}
Target Servlet:
package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
String action = request.getParameter("action");
response.setContentType("text/html");
response.getWriter().println("<html><body>");
if ("redirected".equals(action)) {
response.getWriter().println("<h1>This request was redirected!</h1>");
} else {
response.getWriter().println("<h1>This request was forwarded!</h1>");
}
response.getWriter().println("</body></html>");
}
}