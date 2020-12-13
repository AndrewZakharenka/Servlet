package com.jsp.servlet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest extends Mockito {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void init(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
    }

    @InjectMocks
    LoginServlet loginServlet;

    @Test
    public void testDoPost() throws ServletException, IOException {
        //given
        String email = "test@mail.ru";
        String password = "test";

        //when
        when(request.getParameter("Email")).thenReturn(email);
        when(request.getParameter("Password1")).thenReturn(password);
        when(request.getSession()).thenReturn(session);
        loginServlet.doPost(request, response);

        //then
        verify(request, times(4)).getSession();
    }
}