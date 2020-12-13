package com.jsp.servlet;

import com.jsp.db.CRUDUsers;
import com.jsp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private CRUDUsers crudUsers;

    @Before
    public void init(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        requestDispatcher = mock(RequestDispatcher.class);
        crudUsers = mock(CRUDUsers.class);
    }

    @InjectMocks
    RegisterServlet registerServlet;
    @Test
    public void testDoPost() throws ServletException, IOException {
        //given
        String name = "Test";
        String surname = "Test";
        String email = "test2@mail.ru";
        String password = "test";

        //when
        when(request.getParameter("Name")).thenReturn(name);
        when(request.getParameter("Surname")).thenReturn(surname);
        when(request.getParameter("Email")).thenReturn(email);
        when(request.getParameter("Password1")).thenReturn(password);
        when(request.getParameter("Password2")).thenReturn(password);
        when(request.getRequestDispatcher("jsp/index.jsp")).thenReturn(requestDispatcher);

        when(request.getSession()).thenReturn(session);
        registerServlet.doPost(request, response);

        //then
        verify(request , atLeast(1)).getRequestDispatcher("jsp/index.jsp");
    }
}