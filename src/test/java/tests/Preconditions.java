package tests;

import entity.User;

public class Preconditions extends BaseTest {

    protected final User userWithEmptyUsername = User.builder()
            .password(PASSWORD)
            .username("")
            .build();

    protected final User userWithEmptyPassword = User.builder()
            .password("")
            .username(USERNAME)
            .build();

    protected final User userWithEmptyFields = User.builder()
            .password("")
            .username("")
            .build();

    protected final User userWithIncorrectFields = User.builder()
            .password("Lalala")
            .username("NoNoNo")
            .build();
}
