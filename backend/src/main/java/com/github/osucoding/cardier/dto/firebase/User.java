package com.github.osucoding.cardier.dto.firebase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isVerified;

    private boolean isAdmin;

    public boolean userPayloadValid() {
        return this.getId() != null &&
                this.getUsername() != null &&
                this.getFirstName() != null &&
                this.getLastName() != null &&
                this.getEmail() != null;
    }
}
