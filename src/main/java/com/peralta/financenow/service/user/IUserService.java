package com.peralta.financenow.service.user;

import com.peralta.financenow.domain.model.request.user.UserDTO;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.response.DataResponse;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {

    DataResponse<User> registerNewUser(UserDTO user) throws FinanceNowException;

    DataResponse<User> validateLogin(String username, String password) throws FinanceNowException;

    User findById(Long userId) throws FinanceNowException;

}
