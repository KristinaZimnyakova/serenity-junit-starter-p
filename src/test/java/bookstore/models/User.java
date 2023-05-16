package bookstore.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String userName;
    String password;
}
