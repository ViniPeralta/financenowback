package com.peralta.financenow.service.user;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.request.user.UserDTO;
import com.peralta.financenow.domain.validator.user.UserValidator;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.domain.model.entity.user.User;
import com.peralta.financenow.mapper.user.UserMapper;
import com.peralta.financenow.persistence.user.UserRepository;
import com.peralta.financenow.domain.model.response.DataResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResponse<User> registerNewUser(UserDTO user) throws FinanceNowException {

        UserValidator.validateUsername(userRepository.findByUserName(user.getUserName()));
        UserValidator.validateEmail(userRepository.findByEmail(user.getEmail()));

        return new DataResponse<>(userRepository.save(UserMapper.fromUserDTO(user)));

    }

    @Override
    public DataResponse<User> validateLogin(String username, String password) throws FinanceNowException {

        User user = userRepository.findByUsernameAndPassword(username, password);

        UserValidator.validateUser(user);

        return new DataResponse<>(user);

    }

    @Override
    public User findById(Long userId) throws FinanceNowException {
        return userRepository.findById(userId).orElseThrow(() ->
                new FinanceNowException(
                        FinanceNowExceptionEnum.USER_NOT_FOUND.getErrorCode(),
                        FinanceNowExceptionEnum.USER_NOT_FOUND.getDescription(),
                        "UserService.findById"
                ));
    }
}
