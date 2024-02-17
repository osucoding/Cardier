package com.github.osucoding.cardier.dao.firebase;

import com.github.osucoding.cardier.dto.firebase.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class FirestoreDatabaseDao {

    private final Firestore db;

    private final String USERS_COLLECTION = "users";

    public Optional<User> getUserData(final String id) {
        DocumentReference docRef = db.collection(USERS_COLLECTION).document(id);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document;
        try {
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception happened while retrieving data, e", e);
            return Optional.empty();
        }
        User user;
        assert document != null;
        if (document.exists()) {
            // convert document to POJO
            user = document.toObject(User.class);
            return Optional.ofNullable(user);
        } else {
            log.warn("No such document!");
            return Optional.empty();
        }
    }

    public boolean userExists(final User user) {
        return getUserData(user.getId()).isPresent();
    }

    public boolean insertUserData(final User newUser) {
        ApiFuture<WriteResult> future = db.collection(USERS_COLLECTION).document(newUser.getId()).set(newUser);
        try {
            log.info("User inserted at: " + future.get().getUpdateTime());
            return true;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to save user data", e);
            return false;
        }
    }
}
