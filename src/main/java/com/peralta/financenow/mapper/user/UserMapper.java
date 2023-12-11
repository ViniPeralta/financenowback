package com.peralta.financenow.mapper.user;

import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.request.user.UserDTO;

public class UserMapper {

    private UserMapper() {}

    public static User fromUserDTO(UserDTO userDTO) {

        return User.builder()
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .build();

    }
}
