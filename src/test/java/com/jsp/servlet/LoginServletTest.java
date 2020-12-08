package com.jsp.servlet;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServletTest extends Mockito {

    @Test
    public void testDoPost() throws ServletException, IOException {
        //given
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        String email = "test@mail.ru";
        String password = "test";

        //when
        when(request.getParameter("Email")).thenReturn(email);
        when(request.getParameter("Password1")).thenReturn(password);
        when(request.getSession()).thenReturn(session);
        new LoginServlet().doPost(request, response);

        //then
        verify(request, times(4)).getSession();
//        assertEquals("False", request.getSession().getAttribute("ErrorFlag"));
    }
}