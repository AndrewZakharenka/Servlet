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
        if (users.isEmpty()) {
            assertTrue(false);
        }else {
            assertTrue(true);
        }
    }

    @Test
    public void testSaveUser() {
        //given
        String email = "testSave@mail.ru";
        User user = new User("TestSave", "TestSave", email, "test");

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
        Optional<User> user = Optional.of(CRUDUsers.getUser(email));

        //then
        assertEquals(name, user.get().getName());
    }
}