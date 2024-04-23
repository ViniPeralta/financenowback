package com.peralta.financenow.service.user;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.persistence.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import templates.user.UserTemplates;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should throw an USERNAME_ALREADY_EXISTS exception")
    void registerNewUserError() {

        when(userRepository.findByUserName(any())).thenReturn(UserTemplates.getUser());

        FinanceNowException exception = null;

        try {
            userService.registerNewUser(UserTemplates.getUserDTO());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.USERNAME_ALREADY_EXISTS.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should throw an EMAIL_ALREADY_EXISTS exception")
    void registerNewUserErrorII() {

        when(userRepository.findByEmail(any())).thenReturn(UserTemplates.getUser());

        FinanceNowException exception = null;

        try {
            userService.registerNewUser(UserTemplates.getUserDTO());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.EMAIL_ALREADY_EXISTS.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should return a User")
    void registerNewUser() throws FinanceNowException {

        User expected = UserTemplates.getUser();

        when(userRepository.save(any())).thenReturn(expected);

        User response = userService.registerNewUser(UserTemplates.getUserDTO()).getData();

        assertEquals(expected, response);

    }

    @Test
    @DisplayName("Should throw USER_NOT_FOUND exception")
    void validateLoginError() {

        FinanceNowException exception = null;

        try {
            userService.validateLogin("", "");
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.USER_NOT_FOUND.getDescription(), exception.getMessage());
        assertEquals(FinanceNowExceptionEnum.USER_NOT_FOUND.getErrorCode(), exception.getErrorCode());
        assertEquals("UserValidator.validateUser", exception.getPath());

    }

    @Test
    @DisplayName("Should return a User login data")
    void validateLogin() throws FinanceNowException {

        User expected = UserTemplates.getUser();

        when(userRepository.findByUsernameAndPassword(any(), any())).thenReturn(expected);

        User response = userService.validateLogin("", "").getData();

        assertEquals(expected.getUserName(), response.getUserName());
        assertEquals(expected.getPassword(), response.getPassword());
        assertEquals(expected.getEmail(), response.getEmail());

    }

    @Test
    @DisplayName("Should return user by id")
    void findById() {
        User expected = UserTemplates.getUser();
        when(userRepository.findById(any())).thenReturn(Optional.of(expected));

        User response = userService.findById(1L);

        assertEquals(expected, response);
    }

    @Test
    @DisplayName("Should throw USER_NOT_FOUND exception")
    void findByIdError() {

        assertThrows(FinanceNowException.class, () -> userService.findById(1L));

    }
}