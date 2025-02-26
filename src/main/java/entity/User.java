package entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    String password;
    String username;

}
