package com.peralta.financenow.domain.validator.user;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.entity.user.User;
import com.peralta.financenow.exception.FinanceNowException;

import java.util.Objects;

public class UserValidator {

    private UserValidator() {}

    public static void validateUser(User user) throws FinanceNowException {

        if (Objects.isNull(user)) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.USER_NOT_FOUND.getErrorCode(),
                    FinanceNowExceptionEnum.USER_NOT_FOUND.getDescription(),
                    "UserValidator.validateUser"
            );

        }
    }

    public static void validateUsername(User user) throws FinanceNowException {

        if (Objects.nonNull(user)) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.USERNAME_ALREADY_EXISTS.getErrorCode(),
                    FinanceNowExceptionEnum.USERNAME_ALREADY_EXISTS.getDescription(),
                    "UserValidator.validateUsername"
            );

        }
    }

    public static void validateEmail(User user) throws FinanceNowException {

        if (Objects.nonNull(user)) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.EMAIL_ALREADY_EXISTS.getErrorCode(),
                    FinanceNowExceptionEnum.EMAIL_ALREADY_EXISTS.getDescription(),
                    "UserValidator.validateEmail"
            );

        }
    }

}
