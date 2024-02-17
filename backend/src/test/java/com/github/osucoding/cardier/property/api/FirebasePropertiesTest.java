package com.github.osucoding.cardier.property.api;

import com.github.osucoding.cardier.config.MockedBeansConfigs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(MockedBeansConfigs.class)
public class FirebasePropertiesTest {

    @Autowired
    private FirebaseProperties firebaseProperties;

    @Test
    void testFirebaseProperties() {
        assertNotNull(firebaseProperties);
    }
}
