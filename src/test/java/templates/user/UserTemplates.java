package templates.user;

import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.request.user.UserDTO;

public class UserTemplates {

    public static UserDTO getUserDTO() {
        return UserDTO.builder()
                .userName("username")
                .email("email")
                .password("password")
                .build();
    }

    public static User getUser() {
        return User.builder()
                .id(1L)
                .email("email")
                .userName("username")
                .password("password")
                .build();
    }
}
