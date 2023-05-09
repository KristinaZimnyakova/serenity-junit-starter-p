package bookstore.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegister {
    String firstName;
    String lastName;
    String userName;
    String password;
}
