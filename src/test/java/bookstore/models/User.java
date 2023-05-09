package bookstore.models;

import lombok.Builder;
import lombok.Data;
import org.eclipse.jetty.util.security.Password;

@Data
@Builder
public class User {

    String login;
    String password;
}
