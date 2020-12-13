package com.jsp.db;

import com.jsp.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class CRUDUsersTest {

    @Test
    public void testGetAllUser() {
        // given

        //when
        ArrayList<User> users = CRUDUsers.getAllUsers();

        //then
        assertFalse(users.isEmpty());
    }

    @Test
    public void testSaveUser() {
        //given
        String name = "TestSave";
        String surname = "TestSave";
        String email = "testSave@mail.ru";
        String password = "test";
        User user = new User(name, surname, email, password);

        //when
        user = CRUDUsers.saveUser(user);

        //then
        assertEquals(email, user.getEmail());
        CRUDUsers.removeUserById(user.getId());
    }

    @Test
    public void testGetUser() {
        //given
        String email = "test@mail.ru";
        String name = "Test";

        //when
        User user = CRUDUsers.getUser(email);

        //then
        assertEquals(name, user.getName());
    }
}