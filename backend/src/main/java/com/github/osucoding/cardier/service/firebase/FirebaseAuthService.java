package com.github.osucoding.cardier.service.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class FirebaseAuthService {

    public Optional<String> decodeIdToken(final String idToken) {
        final FirebaseToken decodedToken;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            log.info("Not able to decode user token");
            return Optional.empty();
        }
        return Optional.of(decodedToken.getUid());
    }
}
