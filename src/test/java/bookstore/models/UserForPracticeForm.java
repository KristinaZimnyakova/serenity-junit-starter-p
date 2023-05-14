package bookstore.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForPracticeForm {
    String firstName;
    String lastName;
    String userEmail;
    String userNumber;
    String currentAddress;
}
