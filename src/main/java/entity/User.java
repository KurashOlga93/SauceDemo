package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String password;
    String username;

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
