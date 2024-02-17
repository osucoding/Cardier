package com.github.osucoding.cardier.service.firebase;

import com.github.osucoding.cardier.dao.firebase.FirestoreDatabaseDao;
import com.github.osucoding.cardier.dto.firebase.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FirestoreDatabaseService {

    private final FirestoreDatabaseDao firestoreDatabaseDao;

    public Optional<User> getUserData(final String userId) {
        return firestoreDatabaseDao.getUserData(userId);
    }

    public boolean addUser(final User user) {
        // check if user exists
        if (firestoreDatabaseDao.userExists(user)) {
            log.warn("User already exists with ID: {}", user.getId());
            return false;
        }
        return firestoreDatabaseDao.insertUserData(user);
    }
}
