package com.jsp.servlet;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProfileServletTest {

    @Test
    public void testDoGet() throws ServletException, IOException {
        //given
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        String email = "test@mail.ru";

        //when
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("Email")).thenReturn(email);
        when(request.getRequestDispatcher("/jsp/Profile.jsp")).thenReturn(requestDispatcher);
        new ProfileServlet().doGet(request, response);

        //then
        verify(request, atLeast(1)).getRequestDispatcher("/jsp/Profile.jsp");
    }
}