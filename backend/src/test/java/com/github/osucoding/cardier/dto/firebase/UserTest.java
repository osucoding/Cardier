package com.github.osucoding.cardier.dto.firebase;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void testUserPayloadValid() {
        final User user = new User();
        user.setId("dummy-id");
        user.setUsername("dummy-username");
        user.setFirstName("dummy-first-name");
        user.setLastName("dummy-last-name");
        user.setEmail("dummy-email");
        assertTrue(user.userPayloadValid());
    }

    @Test
    public void testUserPayloadInvalid() {
        final User user = new User();
        user.setId("dummy-id");
        user.setUsername("dummy-username");
        user.setFirstName("dummy-first-name");
        assertFalse(user.userPayloadValid());
    }
}
