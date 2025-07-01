package org.harsh.learning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserResponse {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Integer userId;
    private final String email;
    private final String phoneNumber;
    private final String dateOfBirth;
    private final String gender;
    private final String userType;

}
