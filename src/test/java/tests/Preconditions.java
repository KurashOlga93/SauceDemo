package tests;

import entity.User;

public class Preconditions extends BaseTest {

    public static User userWithEmptyUsername = User.builder()
            .password(PASSWORD)
            .username("")
            .build();

    public static User userWithEmptyPassword = User.builder()
            .password("")
            .username(USERNAME)
            .build();

    public static User userWithEmptyFields = User.builder()
            .password("")
            .username("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .password("Lalala")
            .username("NoNoNo")
            .build();
}
