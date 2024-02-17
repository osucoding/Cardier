package com.github.osucoding.cardier.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
@RequiredArgsConstructor
public class MockedBeansConfigs {

    @MockBean
    private final GoogleCredentials googleCredentials;

    @MockBean
    private final FirebaseApp firebaseApp;

    @MockBean
    private final Firestore firestore;
}
