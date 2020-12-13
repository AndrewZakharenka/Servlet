package com.jsp.servlet;

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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    ProfileServlet profileServlet;

    @Before
    public void init(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        //given
        String email = "test@mail.ru";

        //when
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("Email")).thenReturn(email);
        when(request.getRequestDispatcher("/jsp/Profile.jsp")).thenReturn(requestDispatcher);
        profileServlet.doGet(request, response);

        //then
        verify(request, atLeast(1)).getRequestDispatcher("/jsp/Profile.jsp");
    }
}