package com.jsp.servlet;

import com.jsp.db.CRUDUsers;
import com.jsp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.jsp.repository.InMemoryUsers.inMemoryUsers;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String email = req.getParameter("Email");
        String password = req.getParameter("Password1");

        resp.setContentType("text/html");

        if (CRUDUsers.getAllUsers().stream().anyMatch(u -> u.getEmail().equals(email))) {
            req.getSession().setAttribute("ErrorFlag", "True");
            req.getSession().setAttribute("Error", "this login already exists");
            resp.sendRedirect("jsp/registration.jsp");
        } else {
            if (password.equals(req.getParameter("Password2"))) {
                User user = new User(name, surname, email, password);

                user = CRUDUsers.saveUser(user);
                System.out.println("user add" + user.toString());
                req.getSession().setAttribute("ErrorFlag", "False");
                req.getSession().setAttribute("Error", "");
                req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("ErrorFlag", "True");
                req.getSession().setAttribute("Error", "passwords don't match");
                resp.sendRedirect("jsp/registration.jsp");
            }
        }
    }
}
