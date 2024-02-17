package com.github.osucoding.cardier.controller.v1;

import com.github.osucoding.cardier.dto.firebase.User;
import com.github.osucoding.cardier.service.firebase.FirebaseAuthService;
import com.github.osucoding.cardier.service.firebase.FirestoreDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final FirebaseAuthService firebaseAuthService;

    private final FirestoreDatabaseService firestoreDatabaseService;

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserData(@RequestParam("id") final String id) {
        var optionalToken = firebaseAuthService.decodeIdToken(id);
        if (optionalToken.isPresent()) {
            var token = optionalToken.get();
            final Optional<User> userData = firestoreDatabaseService.getUserData(token);
            return userData.isPresent() ? ResponseEntity.ok(userData) : ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.badRequest().body("Invalid ID");
        }
    }

    @PutMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User newUser, @RequestParam("id") final String id) {
        if (!newUser.userPayloadValid()) {
            return ResponseEntity.badRequest().build();
        }
        var optionalToken = firebaseAuthService.decodeIdToken(id);
        if (optionalToken.isPresent()) {
            var addSucceeded = firestoreDatabaseService.addUser(newUser);
            return addSucceeded ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.badRequest().body("Invalid ID");
        }
    }
}
