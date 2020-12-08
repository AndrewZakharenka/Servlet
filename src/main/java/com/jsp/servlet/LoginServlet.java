package com.jsp.servlet;

import com.jsp.db.CRUDUsers;
import com.jsp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String email = req.getParameter("Email");
        String password = req.getParameter("Password1");

        ArrayList<User> allUsers = CRUDUsers.getAllUsers();

        Optional<User> user = allUsers.stream().filter(u -> u.getEmail().equals(email) &&
                u.getPassword().equals(password)).findAny();

        if (user.isPresent()) {
            req.getSession().setAttribute("authorized", "True");
            req.getSession().setAttribute("Email", user.get().getEmail());
            req.getSession().setAttribute("ErrorFlag", "False");
            req.getSession().setAttribute("Error", "");
            resp.sendRedirect("jsp/index.jsp");
        } else {
            req.getSession().setAttribute("ErrorFlag", "True");
            req.getSession().setAttribute("Error", "Invalid username or password");
            resp.sendRedirect("jsp/login.jsp");
        }

    }
}
